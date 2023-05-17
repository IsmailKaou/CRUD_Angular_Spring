package com.example.test.Student.service;

import com.example.test.Student.entity.Student;
import com.example.test.Student.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    public List<Student> getStudentDetails(Long studentId){
        if(studentId !=null){
            return studentRepository.findAllById(studentId);
        }else{
            return studentRepository.findAll();
        }
    }

    public void deleteStudent(Long studentId){
        studentRepository.deleteById(studentId);
    }
}
