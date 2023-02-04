package com.genspark.studentmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="course_id")
    private Long id;
    @Column(name="course_name", nullable = false)
    private String name;
   /* @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "courses")*/ //bidirectional method
    //private Set<Student> students=new HashSet<>();//bidirectional method
}
