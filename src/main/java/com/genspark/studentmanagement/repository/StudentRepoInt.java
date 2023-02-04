package com.genspark.studentmanagement.repository;

import com.genspark.studentmanagement.model.Course;
import com.genspark.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@Repository
//@Transactional
public interface StudentRepoInt extends JpaRepository<Student,Long> {
    Optional<Student> findById(Long id);
}
