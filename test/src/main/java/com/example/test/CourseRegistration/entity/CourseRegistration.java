package com.example.test.CourseRegistration.entity;

import com.example.test.Course.entity.Course;
import com.example.test.Student.entity.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course_registration")
public class CourseRegistration {


    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;

    private Long finalNote;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
