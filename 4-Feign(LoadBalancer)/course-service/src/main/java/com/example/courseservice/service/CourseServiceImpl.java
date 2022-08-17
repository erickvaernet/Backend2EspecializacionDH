package com.example.courseservice.service;

import com.example.courseservice.dto.SubscriptionDTO;
import com.example.courseservice.model.Course;
import com.example.courseservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final SubscriptionFeignClient subscriptionFeignClient;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, SubscriptionFeignClient subscriptionFeignClient) {
        this.courseRepository = courseRepository;
        this.subscriptionFeignClient = subscriptionFeignClient;
    }

    public ResponseEntity<?> findCourseById(Integer id,Integer userId) {
        ResponseEntity<SubscriptionDTO> responseEntity = subscriptionFeignClient.findByUserId(userId);
        System.out.println(responseEntity.getHeaders().get("port"));
        SubscriptionDTO subscriptionDTO = responseEntity.getBody();
        if(Objects.nonNull(subscriptionDTO)){
            return  subscriptionDTO.getEndDate().isAfter(LocalDateTime.now()) ?
                    new ResponseEntity<>(courseRepository.findById(id).orElse(null), HttpStatus.OK) :
                    new ResponseEntity<>("La subscripcion del usuario ha finalizado ",HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>("No existe la entidad", HttpStatus.NOT_FOUND);
    }

}
