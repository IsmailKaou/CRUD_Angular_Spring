package com.example.test.Student.entity;


import com.example.test.CourseRegistration.entity.CourseRegistration;
import com.example.test.Professor.entity.Professor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String Name;
    private String Gender;
    private String BirthDate;
    private float Mark;

    @JsonIgnore
    @Fetch(FetchMode.JOIN)
    @ManyToMany(mappedBy = "assignedStudents")
    private Set<Professor> professors = new HashSet<>();

    @Fetch(FetchMode.JOIN)
    @OneToMany(mappedBy = "student")
    private Set<CourseRegistration> courseRegistrations = new HashSet<>();



    //    @ManyToMany(mappedBy = "students")
    //    private List<Course> courses;
}
