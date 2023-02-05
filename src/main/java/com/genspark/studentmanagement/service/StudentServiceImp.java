package com.genspark.studentmanagement.service;

import com.genspark.studentmanagement.model.Course;
import com.genspark.studentmanagement.model.Student;
import com.genspark.studentmanagement.repository.StudentRepoInt;
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
//@Component
public class StudentServiceImp implements StudentServiceInt{
//CRUD operations
    @Autowired
    StudentRepoInt studentRepo;
    //R=Read
    @Override
    public List<Student> getAllStudents() {

        return studentRepo.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {

        return studentRepo.findById(id);
    }

    @Override
    public Set<Course> getAllStudentCourses(Long id) {
        Student student =studentRepo.findById(id).get();
        Set<Course> courses=student.getCourses();
        return courses;
    }
    //C=Create
    @Override
    public Student addStudent(Student student) {

        return studentRepo.save(student);
    }

    //D=Delete
    @Override
    public void deleteStudent(Long id) {

        studentRepo.deleteById(id);
    }

    @Override
    public void deleteAllStudents() {
        studentRepo.deleteAll();
    }
    //U=Update
    public void updateStudent(Long id,Student student){
        Optional<Student> std=studentRepo.findById(id);
        if(std.isPresent()){
            Student temp=std.get();
            temp.setFirstName(student.getFirstName());
            temp.setLastName(student.getLastName());
            temp.setCourses(student.getCourses());
            studentRepo.save(temp);
        }
        else System.out.println(" the student with the given id doesn't exist");
    }

}
