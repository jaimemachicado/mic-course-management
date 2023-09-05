package com.school.coursemanagement.services;

import com.school.coursemanagement.domain.dtos.CourseDto;

public interface GetCourseById {

  CourseDto getCourseById(Integer id);
}
