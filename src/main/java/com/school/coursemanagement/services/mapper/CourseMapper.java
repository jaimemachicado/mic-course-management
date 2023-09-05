package com.school.coursemanagement.services.mapper;

import com.school.coursemanagement.domain.dtos.CourseDto;
import com.school.coursemanagement.infrastructure.persistence.entities.Course;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

  CourseDto courseToCourseDto(Course course);

  Course courseDtoToCourse(CourseDto course);

  List<CourseDto> coursesToCoursesDtos(List<Course> courses);
}
