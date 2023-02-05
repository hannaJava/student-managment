package com.genspark.studentmanagement.service;

import com.genspark.studentmanagement.model.Course;
import com.genspark.studentmanagement.model.Student;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CourseServiceInt {
    //CRUD operations
    //Read
    List<Course> getAllCourses();
    Optional<Course> getCourseById(Long id);
    //courses related to a student
    Set<Student> getAllCourseStudents(Long id);
    //Create
    Course addCourse(Course course);
    //Delete
    void deleteCourse(Long id);
    void deleteAllCourses();
    //Update
    void updateCourse(Long id,Course course);
}
