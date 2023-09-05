package com.school.coursemanagement.controllers.mapper;

import com.school.coursemanagement.domain.dtos.CourseDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.openapitools.model.CourseDTO;

@Mapper(componentModel = "spring")
public interface CourseApiMapper {

  CourseDTO courseDtoToCourseDTO(CourseDto courseDto);

  CourseDto courseDTOToCourseDto(CourseDTO courseDTO);

  List<CourseDTO> courseDtosToCourseDTOs(List<CourseDto> courseDtos);
}
