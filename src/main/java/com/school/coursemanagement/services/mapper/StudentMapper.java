package com.school.coursemanagement.services.mapper;

import com.school.coursemanagement.domain.dtos.StudentDto;
import com.school.coursemanagement.infrastructure.persistence.entities.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {

  StudentDto studentToStudentDto(Student student);

  Student studentDtoToStudent(StudentDto studentDto);
}
