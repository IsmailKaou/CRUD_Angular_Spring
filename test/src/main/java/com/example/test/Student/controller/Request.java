package com.example.test.Student.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    private Long id;
    private String name;
    private String gender;
    private String birthDate;
    private float mark;
}
