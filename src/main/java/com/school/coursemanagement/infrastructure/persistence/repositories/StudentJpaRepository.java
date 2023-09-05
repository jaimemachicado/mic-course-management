package com.school.coursemanagement.infrastructure.persistence.repositories;

import com.school.coursemanagement.infrastructure.persistence.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentJpaRepository extends JpaRepository<Student, Integer> {

}
