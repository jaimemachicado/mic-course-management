package com.school.coursemanagement.services.impl;

import com.school.coursemanagement.domain.dtos.CourseDto;
import com.school.coursemanagement.infrastructure.persistence.repositories.CourseJpaRepository;
import com.school.coursemanagement.services.GetAllCourses;
import com.school.coursemanagement.services.mapper.CourseMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetAllCoursesImpl implements GetAllCourses {

  @Autowired
  private final CourseJpaRepository courseJpaRepository;

  @Autowired
  private final CourseMapper courseMapper;

  @Override
  public List<CourseDto> getAllCourses() {
    return courseMapper.coursesToCoursesDtos(courseJpaRepository.findAll());
  }
}
