package com.genspark.studentmanagement.repository;

import com.genspark.studentmanagement.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepoInt extends JpaRepository<Course, Long> {
    Optional<Course> findById(Long id);
}
