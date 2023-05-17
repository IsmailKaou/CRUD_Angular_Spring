package com.example.test.Professor.repository;

import com.example.test.Professor.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor,Long> {
    public List<Professor> findAllById(long id);
}
