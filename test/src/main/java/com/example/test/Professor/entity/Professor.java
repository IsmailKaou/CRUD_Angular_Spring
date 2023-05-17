package com.example.test.Professor.entity;

import com.example.test.Course.entity.Course;
import com.example.test.Student.entity.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "professors")
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToMany
    @Fetch(FetchMode.JOIN)
    @JoinTable(name = "professor_student",
    joinColumns = @JoinColumn(name = "professor_id"),
    inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> assignedStudents = new HashSet<>();

//    @OneToOne(mappedBy = "professor")
//    private Course course;




}
