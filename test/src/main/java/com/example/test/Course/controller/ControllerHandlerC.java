//package com.example.test.Course.controller;
//
//import com.example.test.Course.entity.Course;
//import com.example.test.Course.repository.CourseRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//
//@Service
//@RequiredArgsConstructor
//public class ControllerHandlerC {
//    private final CourseRepository courseRepository;
//    public Response addCourse(Request request){
//        Course course = new Course();
//
////        course.setFiliere(request.getName());
//        course.setTitle(request.getTitle());
//        courseRepository.save(course);
//
//        return Response.builder()
//                .msg("Course added Successfully")
//                .build();
//    }
//
//    public Response updateStudent(Request request, Long id) {
//        Course course = courseRepository.findById(id).get();
////        course.set
////        course.setFiliere(request.getName());
//
//        return Response.builder()
//                .msg("Student updated Successfully")
//                .build();
//
//
//    }
//}
