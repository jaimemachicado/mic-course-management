package com.school.coursemanagement.services;

import com.school.coursemanagement.domain.dtos.CourseDto;

public interface CreateCourse {

  CourseDto createOrUpdateCourse(CourseDto courseDto);
}
