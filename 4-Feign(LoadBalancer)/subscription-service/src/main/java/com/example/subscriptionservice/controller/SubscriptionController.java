package com.example.subscriptionservice.controller;

import com.example.subscriptionservice.model.Subscription;
import com.example.subscriptionservice.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    @Value("${server.port}")
    private String port;

    private final SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping
    public ResponseEntity<Subscription> findByUserId(@RequestParam Integer userId, HttpServletResponse response) {
        response.addHeader("port", port);
        return ResponseEntity.ok(subscriptionService.findByUserId(userId));
    }


}
