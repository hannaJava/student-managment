package com.genspark.studentmanagement.service;

import com.genspark.studentmanagement.model.Course;
import com.genspark.studentmanagement.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentServiceInt {
    //CRUD operations
    //Read
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    //courses related to a student
    List<Course> getAllStudentCourses(Long id);
    //Create
    Student addStudent(Student student);
    //Delete
    void deleteStudent(Long id);
    void deleteAllStudents();
    //Update
    void updateStudent(Long id,Student student);

}
