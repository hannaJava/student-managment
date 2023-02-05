package com.genspark.studentmanagement.controller;

import com.genspark.studentmanagement.model.Course;
import com.genspark.studentmanagement.model.Student;
import com.genspark.studentmanagement.service.CourseServiceInt;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController//=@Controller+@ResponseBody
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("/api")
public class CourseController {
    @Autowired
    CourseServiceInt courseService;

    @GetMapping("/courses")
    public List<Course> getAllCourses(){
        List<Course> courseList=courseService.getAllCourses();
        return courseList;
    }
    @GetMapping("/courses/{id}")
    public Optional<Course> getCourseById(@PathVariable("id") Long id){

        return courseService.getCourseById(id);
    }
    @GetMapping("/coursestudents/{id}")//not completed
    public List<Student>getCourseStudents(@PathVariable("id") Long id){
        return courseService.getAllCourseStudents(id);
    }
    @PostMapping("/addcourse")
    public Course addCourse(@RequestBody Course course){
        courseService.addCourse(course);
        return course;
    }
    @DeleteMapping("/deletecourse/{id}")
    public Course deleteCourse(@PathVariable("id") Long id,@RequestBody Course course){
        courseService.deleteCourse(id);
        return course;
    }

    @DeleteMapping("/deletecourses")
    public void deleteAllCourses(){

        courseService.deleteAllCourses();
    }
    @PutMapping("/updatecourse/{id}")
    public Course updateCourse(@PathVariable("id") Long id,@RequestBody Course course){
        courseService.updateCourse(id,course);
        return course;
    }
}
