package com.example.test.Course.repository;

import com.example.test.Course.entity.Course;
import com.example.test.Professor.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Long> {
    public List<Course> findAllById(long id);
}
