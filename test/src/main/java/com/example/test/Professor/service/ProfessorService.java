package com.example.test.Professor.service;

import com.example.test.Professor.entity.Professor;
import com.example.test.Professor.repository.ProfessorRepository;
import com.example.test.Student.entity.Student;
import com.example.test.Student.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final ProfessorRepository professorRepository;
    private final StudentRepository studentRepository;

    public void saveProfessor(Professor professor){
        professorRepository.save(professor);
    }

    public List<Professor> getProfessorDetails(Long profId){
        if(profId !=null){
            return professorRepository.findAllById(profId);
        }else{
            return professorRepository.findAll();
        }
    }

    public void deleteProfessor(Long profId){
        professorRepository.deleteById(profId);
    }

    public Professor assignStudentToProfessor(Long professorId, Long studentId) {
        Set<Student> studentSet = null;
        Professor professor = professorRepository.findById(professorId).get();
        Student student = studentRepository.findById(studentId).get();

        studentSet = professor.getAssignedStudents();
        studentSet.add(student);
        professor.setAssignedStudents(studentSet);

        return professorRepository.save(professor);
    }
}
