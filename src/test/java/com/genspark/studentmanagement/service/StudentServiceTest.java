package com.genspark.studentmanagement.service;

import com.genspark.studentmanagement.model.Student;
import com.genspark.studentmanagement.repository.StudentRepoInt;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentServiceTest {

    //StudentRepoInt studentRepo;
   // @Autowired
    @Mock
    StudentRepoInt studentRepo;
    @InjectMocks
    StudentServiceImp studentService;
    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void getAllStudentsTest(){
        List<Student> actual=new ArrayList<Student>();
        Student s;
        s=new Student(1l,"Hana","Mager",null,null);
        actual.add(s);
        s=new Student(2l,"Bana","Mager",null,null);
        actual.add(s);
        Mockito.when(studentRepo.findAll()).thenReturn(actual);
        List<Student> expected=studentService.getAllStudents();
        Assert.assertEquals(expected,actual);
    }
}
