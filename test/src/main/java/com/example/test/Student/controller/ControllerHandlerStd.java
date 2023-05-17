package com.example.test.Student.controller;


import com.example.test.Student.entity.Student;
import com.example.test.Student.entity.Student;
import com.example.test.Student.repository.StudentRepository;
import com.example.test.Student.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class ControllerHandlerStd {
    private final StudentRepository studentRepository;
    public Response addStudent(Request request){
        Student student = new Student();
        System.out.println(request.getName());
        student.setName(request.getName());
        student.setGender(request.getGender());
        student.setBirthDate(request.getBirthDate());
        student.setMark(request.getMark());
        studentRepository.save(student);

        return Response.builder()
                .msg("Student added Successfully")
                .build();
    }
    public Response updateStudent(Request request, Long id) {
        Student student = studentRepository.findById(id).get();
        student.setName(request.getName());
        student.setGender(request.getGender());
        student.setBirthDate(request.getBirthDate());
        student.setMark(request.getMark());
        studentRepository.save(student);

        return com.example.test.Student.controller.Response.builder()
                .msg("Student updated Successfully")
                .build();


    }
}
