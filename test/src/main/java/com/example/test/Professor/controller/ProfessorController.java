package com.example.test.Professor.controller;

import com.example.test.Professor.entity.Professor;
import com.example.test.Professor.service.ProfessorService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/professor")
@RequiredArgsConstructor
public class ProfessorController {
    private final ControllerHandler controllerHandler;
    private final ProfessorService professorService;

    @PostMapping("/save")
    public ResponseEntity<Response> createProfessor(@RequestBody Request request) {
//        professorService.saveProfessor(projectObj);
        return ResponseEntity.ok(controllerHandler.addProfessor(request));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Response> updateProfessor(@RequestBody Request request,@PathVariable Long id){
        return ResponseEntity.ok(controllerHandler.updateProfessor(request,id));
    }


    @GetMapping(value = {"/getProfessors"})
    public List<Professor> getProfessors() {
        return professorService.getProfessorDetails(null);
    }

    @GetMapping(value = {"/getProfessors/{id}"})
    public List<Professor> getProfessors(@PathVariable Long id) {
        return professorService.getProfessorDetails(id);
    }


    @DeleteMapping("/delete/{professorId}")
    public ResponseEntity removeProfessor(@PathVariable Long professorId) {
        professorService.deleteProfessor(professorId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{professorId}/student/{studentId}")
    public Professor assignStudentToProfessor(
            @PathVariable Long professorId,
            @PathVariable Long studentId
    ){
        return professorService.assignStudentToProfessor(professorId, studentId);
    }
}
