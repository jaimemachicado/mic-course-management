package com.school.coursemanagement.infrastructure.persistence.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "STUDENT")
public class Student {

  @Id
  private Integer id;
  private String firstName;
  private String lastName;
  private String email;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "COURSE_ID")
  private Course course;
}
