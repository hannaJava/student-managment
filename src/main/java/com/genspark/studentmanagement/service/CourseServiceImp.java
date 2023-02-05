package com.genspark.studentmanagement.service;

import com.genspark.studentmanagement.model.Course;
import com.genspark.studentmanagement.model.Student;
import com.genspark.studentmanagement.repository.CourseRepoInt;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class CourseServiceImp implements CourseServiceInt{
    @Autowired
    CourseRepoInt courseRepo;
    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public Optional<Course> getCourseById(Long id) {
        return courseRepo.findById(id);
    }

    @Override
    public Set<Student> getAllCourseStudents(Long id) {
        Course course =courseRepo.findById(id).get();
        //Set<Student> students=course.getStudents();
        //return students;
        return null;
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepo.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
            courseRepo.deleteById(id);
    }

    @Override
    public void deleteAllCourses() {
        courseRepo.deleteAll();
    }

    @Override
    public void updateCourse(Long id, Course course) {
        Optional<Course> std=courseRepo.findById(id);
        if(std.isPresent()){
            Course temp=std.get();
            temp.setName(course.getName());
            courseRepo.save(temp);
        }
        else System.out.println(" the course with the given id doesn't exist");
    }
}
