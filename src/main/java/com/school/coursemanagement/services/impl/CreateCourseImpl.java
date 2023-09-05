package com.school.coursemanagement.services.impl;

import com.school.coursemanagement.domain.dtos.CourseDto;
import com.school.coursemanagement.domain.dtos.StudentDto;
import com.school.coursemanagement.infrastructure.clients.StudentClient;
import com.school.coursemanagement.infrastructure.persistence.entities.Course;
import com.school.coursemanagement.infrastructure.persistence.entities.Student;
import com.school.coursemanagement.infrastructure.persistence.repositories.CourseJpaRepository;
import com.school.coursemanagement.infrastructure.persistence.repositories.StudentJpaRepository;
import com.school.coursemanagement.services.CreateCourse;
import com.school.coursemanagement.services.mapper.CourseMapper;
import com.school.coursemanagement.services.mapper.StudentMapper;
import jakarta.transaction.Transactional;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCourseImpl implements CreateCourse {

  @Autowired
  private final CourseJpaRepository courseJpaRepository;

  @Autowired
  private final StudentJpaRepository studentJpaRepository;

  @Autowired
  private final CourseMapper courseMapper;

  @Autowired
  private final StudentMapper studentMapper;

  @Autowired
  private final StudentClient studentClient;

  @Override
  @Transactional
  public CourseDto createOrUpdateCourse(CourseDto courseDto) {
    Course course = courseMapper.courseDtoToCourse(courseDto);
    course.setStudents(null);

    course = courseJpaRepository.save(course);

    for (StudentDto studentDto : courseDto.getStudents()) {
      Student student = studentMapper.studentDtoToStudent(studentDto);
      student.setCourse(course);
      if (Objects.isNull(student.getId())) {
        Integer studentId = studentClient.findStudentIdByEmail(studentDto.getEmail()).getBody();
        if (Objects.isNull(studentId)) {
          studentId
              = Objects.requireNonNull(studentClient.createOrUpdateStudent(studentDto).getBody())
              .getId();
        }
        student.setId(studentId);
        studentDto.setId(studentId);
      }
      studentJpaRepository.save(student);
      // Call to student management microservice to create or update student
      studentClient.createOrUpdateStudent(studentDto);
    }

    return courseDto;
  }

}
