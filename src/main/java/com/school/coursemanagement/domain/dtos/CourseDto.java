package com.school.coursemanagement.domain.dtos;

import java.util.List;
import lombok.Data;

@Data
public class CourseDto {

  private Integer id;
  private String name;
  private List<StudentDto> students;
}
