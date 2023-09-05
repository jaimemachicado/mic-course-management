package com.school.coursemanagement.infrastructure.clients;

import com.school.coursemanagement.domain.dtos.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "student", url = "localhost:8080")
public interface StudentClient {

  @PostMapping(value = "/student")
  ResponseEntity<StudentDto> createOrUpdateStudent(StudentDto studentDto);

  @GetMapping(value = "/student/by-email")
  ResponseEntity<Integer> findStudentIdByEmail(@RequestParam("email") String email);
}
