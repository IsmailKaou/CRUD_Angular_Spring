package com.example.test.CourseRegistration.controller;

import com.example.test.CourseRegistration.entity.CourseRegistration;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/courseRegistration")
@RequiredArgsConstructor
public class CourseRegistrationController {
    private final ControllerHandlerCR controllerHandler;
//    private final CourseRegistrationService professorService;

    @PostMapping("/save")
    public ResponseEntity<Response> createCourseRegistration(@RequestBody Request request) {
//        professorService.saveCourseRegistration(projectObj);
        return ResponseEntity.ok(controllerHandler.addCourseRegistration(request));
    }

//    @PostMapping("/update/{id}")
//    public ResponseEntity<Response> updateStudent(@RequestBody Request request,@PathVariable Long id){
//        return ResponseEntity.ok(controllerHandler.updateStudent(request,id));
//    }



}
