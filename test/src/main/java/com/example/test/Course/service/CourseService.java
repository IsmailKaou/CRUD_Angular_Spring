//package com.example.test.Course.service;
//
//import com.example.test.Course.entity.Course;
//import com.example.test.Course.repository.CourseRepository;
//import com.example.test.Professor.entity.Professor;
//import com.example.test.Professor.repository.ProfessorRepository;
//import com.example.test.Student.entity.Student;
//import com.example.test.Student.repository.StudentRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Set;
//
//
//@Service
//@RequiredArgsConstructor
//public class CourseService {
//    private final CourseRepository courseRepository;
//    private final StudentRepository studentRepository;
//
//    public void saveCourse(Course course){
//        courseRepository.save(course);
//    }
//
//    public List<Course> getCourseDetails(Long courseId){
//        if(courseId !=null){
//            return courseRepository.findAllById(courseId);
//        }else{
//            return courseRepository.findAll();
//        }
//    }
//
//    public void deleteProfessor(Long courseId){
//        courseRepository.deleteById(courseId);
//    }
//
//
//}
