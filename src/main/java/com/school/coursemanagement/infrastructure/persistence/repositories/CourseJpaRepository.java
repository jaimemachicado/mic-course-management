package com.school.coursemanagement.infrastructure.persistence.repositories;

import com.school.coursemanagement.infrastructure.persistence.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseJpaRepository extends JpaRepository<Course, Integer> {

}
