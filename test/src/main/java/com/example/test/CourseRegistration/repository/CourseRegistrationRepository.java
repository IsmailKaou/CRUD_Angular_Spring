package com.example.test.CourseRegistration.repository;

import com.example.test.CourseRegistration.entity.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration,Long> {

}
