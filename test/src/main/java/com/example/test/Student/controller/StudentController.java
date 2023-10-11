package com.example.test.Student.controller;

import com.example.test.Professor.entity.Professor;
import com.example.test.Student.entity.Student;
import com.example.test.Student.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// here is the student controller

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {
    private final ControllerHandlerStd controllerHandler;
    private final StudentService studentService;
    @PostMapping("/save")
    public ResponseEntity<Response> createProfessor(@RequestBody Request request) {
        return ResponseEntity.ok(controllerHandler.addStudent(request));
    }
    @PostMapping("/update/{id}")
    public ResponseEntity<Response> updateStudent(@RequestBody Request request, @PathVariable Long id){
        return ResponseEntity.ok(controllerHandler.updateStudent(request,id));
    }


    @GetMapping(value = {"/getStudents",})
    public List<Student> getStudents() {
        return studentService.getStudentDetails(null);
    }

    @GetMapping(value = {"/getStudents/{id}"})
    public List<Student> getProfessors(@PathVariable Long id) {
        return studentService.getStudentDetails(id);
    }

    @DeleteMapping("/delete/{studentId}")
    public ResponseEntity removeStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
