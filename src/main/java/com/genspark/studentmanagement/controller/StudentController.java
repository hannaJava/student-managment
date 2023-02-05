package com.genspark.studentmanagement.controller;

import com.genspark.studentmanagement.model.Course;
import com.genspark.studentmanagement.model.Student;
import com.genspark.studentmanagement.service.StudentServiceInt;
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
public class StudentController {
    @Autowired
    StudentServiceInt studentService;
    @GetMapping("/students")
    public List<Student> getAllStudents(){
        List<Student> studentList=studentService.getAllStudents();
        return studentList;
    }
    @GetMapping("/students/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") Long id){

        return studentService.getStudentById(id);
    }
    @GetMapping("/studentcourses/{id}")//not completed
    public List<Course>getStudentCourses(@PathVariable("id") Long id){
        return studentService.getAllStudentCourses(id);
    }
    @PostMapping("/addstudent")
    public Student addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return student;
    }

    @DeleteMapping("/deletestudent/{id}")
    public Student deleteStudent(@PathVariable("id") Long id,@RequestBody Student student){
        studentService.deleteStudent(id);
        return student;
    }

    @DeleteMapping("/deletestudents")
    public void deleteAllStudents(){
        studentService.deleteAllStudents();
    }

    @PutMapping("/updatestudent/{id}")
    public Student updateStudent(@PathVariable("id") Long id,@RequestBody Student student){
        studentService.updateStudent(id,student);
        return student;
    }
}

 /* Scanner input=new Scanner(System.in);
        System.out.println("enter id : ");
        Long id=input.nextLong();
        input=new Scanner(System.in);
        System.out.println("enter first name : ");
        String firstName=input.nextLine();
        System.out.println("enter last name : ");
        String lastName=input.nextLine();
        Student s=new Student(id,firstName,lastName,null,null);
        //studentService.save(s);//,null));*/