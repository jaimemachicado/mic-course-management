package com.school.coursemanagement.controllers.mapper;

import com.school.coursemanagement.domain.dtos.StudentDto;
import java.util.List;
import org.mapstruct.Mapper;
import org.openapitools.model.StudentDTO;

@Mapper(componentModel = "spring")
public interface StudentApiMapper {

  StudentDto studentDTOToStudentDto(StudentDTO studentDTO);

  StudentDTO studentDtoToStudentDTO(StudentDto studentDto);

  List<StudentDto> studentDTOsToStudentDtos(List<StudentDTO> studentDTOs);
}
