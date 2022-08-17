package com.example.courseservice.service;

import com.example.courseservice.dto.SubscriptionDTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="subscription-service")
@LoadBalancerClient(name = "subscription-service")
public interface SubscriptionFeignClient {

    @GetMapping("/subscriptions")
    public ResponseEntity<SubscriptionDTO> findByUserId(@RequestParam  Integer userId);
}
