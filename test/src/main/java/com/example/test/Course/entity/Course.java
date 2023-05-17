package com.example.test.Course.entity;

import com.example.test.CourseRegistration.entity.CourseRegistration;
import com.example.test.Professor.entity.Professor;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;

    @OneToMany(mappedBy = "course")
    private Set<CourseRegistration> courseRegistrationSet = new HashSet<>();

    @OneToOne(mappedBy = "course")
    private Professor professor;

}
