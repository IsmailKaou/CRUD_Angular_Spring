package com.example.test.Professor.controller;

import com.example.test.Professor.entity.Professor;
import com.example.test.Professor.repository.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ControllerHandler {
    private final ProfessorRepository professorRepository;
    public Response addProfessor(Request  request){
        Professor professor = new Professor();
        professor.setFirstName(request.getFirstName());
        professor.setLastName(request.getLastName());
        professor.setEmail(request.getEmail());
//        professor.setFiliere(request.getName());
        professorRepository.save(professor);

        return Response.builder()
                .msg("Professor added Successfully")
                .build();
    }

    public Response updateProfessor(Request request, Long id) {
        Professor professor = professorRepository.findById(id).get();
        professor.setEmail(request.getEmail());
        professor.setFirstName(request.getFirstName());
        professor.setLastName(request.getLastName());
        professorRepository.save(professor);
        return Response.builder()
                .msg("Professor updated Successfully")
                .build();


    }
}
