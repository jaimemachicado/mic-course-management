package com.school.coursemanagement.services.impl;

import com.school.coursemanagement.controllers.mapper.StudentApiMapper;
import com.school.coursemanagement.domain.dtos.CourseDto;
import com.school.coursemanagement.services.CreateCourse;
import com.school.coursemanagement.services.GetCourseById;
import com.school.coursemanagement.services.RegisterStudents;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.openapitools.model.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterStudentImpl implements RegisterStudents {

  @Autowired
  private final GetCourseById getCourseById;

  @Autowired
  private final CreateCourse createCourse;

  @Autowired
  private final StudentApiMapper studentApiMapper;

  @Override
  public void registerStudents(Integer idCourse, List<StudentDTO> studentDTOs) {
    CourseDto course = getCourseById.getCourseById(idCourse);
    course.getStudents().addAll(studentApiMapper.studentDTOsToStudentDtos(studentDTOs));
    createCourse.createOrUpdateCourse(course);
  }
}
