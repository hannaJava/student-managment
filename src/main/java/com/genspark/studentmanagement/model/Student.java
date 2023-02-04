package com.genspark.studentmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="student_id")
    private Long id;
    @Column(name= "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @ManyToMany(targetEntity = Course.class) //uniderctional methods
    @JoinTable(name="students_courses",
            joinColumns = {@JoinColumn(name="student_id")},
            inverseJoinColumns = {@JoinColumn(name="course_id")}
              )
    private Set<Course> courses;
    /*@ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)*/ //bidirectional method
}
