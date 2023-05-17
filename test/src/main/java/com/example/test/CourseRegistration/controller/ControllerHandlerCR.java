package com.example.test.CourseRegistration.controller;

import com.example.test.CourseRegistration.controller.Request;
import com.example.test.CourseRegistration.controller.Response;
import com.example.test.CourseRegistration.entity.CourseRegistration;
import com.example.test.CourseRegistration.repository.CourseRegistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ControllerHandlerCR {
    private final CourseRegistrationRepository courseRegistrationRepository;
    public Response addCourseRegistration(Request request){
        CourseRegistration courseRegistration = new CourseRegistration();

//        professor.setFiliere(request.getName());
        courseRegistrationRepository.save(courseRegistration);

        return Response.builder()
                .msg("CourseRegistration added Successfully")
                .build();
    }


}
