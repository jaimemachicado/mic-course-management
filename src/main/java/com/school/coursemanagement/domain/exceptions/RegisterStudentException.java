package com.school.coursemanagement.domain.exceptions;

public class RegisterStudentException extends RuntimeException {

  public RegisterStudentException(String errorMessage) {
    super(errorMessage);
  }
}
