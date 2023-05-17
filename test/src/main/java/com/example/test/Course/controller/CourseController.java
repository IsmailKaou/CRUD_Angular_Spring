//package com.example.test.Course.controller;
//
//import com.example.test.Course.entity.Course;
//import com.example.test.Course.service.CourseService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//
//@RestController
//@RequestMapping("/professor")
//@RequiredArgsConstructor
//public class CourseController {
//    private final ControllerHandlerC controllerHandlerC;
//    private final CourseService courseService;
//
//    @PostMapping("/save")
//    public ResponseEntity<Response> createCourse(@RequestBody Request request) {
////        professorService.saveCourse(projectObj);
//        return ResponseEntity.ok(controllerHandlerC.addCourse(request));
//    }
//
//    @PostMapping("/update/{id}")
//    public ResponseEntity<Response> updateStudent(@RequestBody Request request, @PathVariable Long id){
//        return ResponseEntity.ok(controllerHandlerC.updateStudent(request,id));
//    }
//
//
//    @GetMapping(value = {"/getCourses"})
//    public List<Course> getCourses() {
//        return courseService.getCourseDetails(null);
//    }
//
//    @GetMapping(value = {"/getCourses/{id}"})
//    public List<Course> getCourses(@PathVariable Long id) {
//        return courseService.getCourseDetails(id);
//    }
//
//
//
//
////    @DeleteMapping("/delete/{professorId}")
////    public ResponseEntity removeCourse(@PathVariable Long professorId) {
////        courseService.deleteCourse(professorId);
////        return new ResponseEntity(HttpStatus.OK);
////    }
////
////    @PutMapping("/{professorId}/student/{studentId}")
////    public Course assignStudentToCourse(
////            @PathVariable Long professorId,
////            @PathVariable Long studentId
////    ){
////        return courseService.assignStudentToCourse(professorId, studentId);
////    }
//}
