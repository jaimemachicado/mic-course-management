package com.school.coursemanagement.services.impl;

import com.school.coursemanagement.domain.dtos.CourseDto;
import com.school.coursemanagement.domain.exceptions.RegisterStudentException;
import com.school.coursemanagement.infrastructure.persistence.entities.Course;
import com.school.coursemanagement.infrastructure.persistence.repositories.CourseJpaRepository;
import com.school.coursemanagement.services.GetCourseById;
import com.school.coursemanagement.services.mapper.CourseMapper;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCourseByIdImpl implements GetCourseById {

  @Autowired
  private final CourseJpaRepository courseJpaRepository;
  @Autowired
  private final CourseMapper courseMapper;

  @Override
  public CourseDto getCourseById(Integer id) {
    Optional<Course> courseOptional = courseJpaRepository.findById(id);
    if (courseOptional.isPresent()) {
      return courseMapper.courseToCourseDto(courseOptional.get());
    }
    throw new RegisterStudentException("Course not exist");
  }
}
