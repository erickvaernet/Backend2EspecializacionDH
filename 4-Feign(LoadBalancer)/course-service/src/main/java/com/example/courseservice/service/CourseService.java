package com.example.courseservice.service;

import org.springframework.http.ResponseEntity;

public interface CourseService {
    public ResponseEntity<?> findCourseById(Integer id, Integer userId);
}
