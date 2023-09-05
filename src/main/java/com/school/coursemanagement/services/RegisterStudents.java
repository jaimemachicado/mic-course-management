package com.school.coursemanagement.services;

import java.util.List;
import org.openapitools.model.StudentDTO;

public interface RegisterStudents {

  void registerStudents(Integer idCourse, List<StudentDTO> studentDTO);
}
