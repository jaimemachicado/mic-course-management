package com.school.coursemanagement.controllers;


import com.school.coursemanagement.controllers.mapper.CourseApiMapper;
import com.school.coursemanagement.services.CreateCourse;
import com.school.coursemanagement.services.GetAllCourses;
import com.school.coursemanagement.services.GetCourseById;
import com.school.coursemanagement.services.RegisterStudents;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.CourseApi;
import org.openapitools.model.CourseDTO;
import org.openapitools.model.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CourseManagementController implements CourseApi {

  @Autowired
  private final CourseApiMapper courseApiMapper;

  @Autowired
  private final GetAllCourses getAllCourses;

  @Autowired
  private final CreateCourse createCourse;

  @Autowired
  private final GetCourseById getCourseById;

  @Autowired
  private final RegisterStudents registerStudents;


  @Override
  public ResponseEntity<CourseDTO> createCourse(CourseDTO courseDTO) {
    return ResponseEntity.ok()
        .body(courseApiMapper.courseDtoToCourseDTO(
            createCourse.createOrUpdateCourse(courseApiMapper.courseDTOToCourseDto(courseDTO))));
  }

  @Override
  public ResponseEntity<List<CourseDTO>> getAllCourses() {
    return ResponseEntity.ok()
        .body(courseApiMapper.courseDtosToCourseDTOs(getAllCourses.getAllCourses()));
  }

  @Override
  public ResponseEntity<CourseDTO> getCourseById(Integer id) {
    return ResponseEntity.ok(courseApiMapper.courseDtoToCourseDTO(getCourseById.getCourseById(id)));
  }

  @Override
  public ResponseEntity<Void> registerStudent(String idCourse, List<StudentDTO> studentDTOs) {
    registerStudents.registerStudents(Integer.valueOf(idCourse), studentDTOs);
    return ResponseEntity.ok().build();
  }
}
