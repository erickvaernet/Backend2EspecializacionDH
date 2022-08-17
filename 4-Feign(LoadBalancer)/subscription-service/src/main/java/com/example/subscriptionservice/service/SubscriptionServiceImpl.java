package com.example.subscriptionservice.service;

import com.example.subscriptionservice.model.Subscription;
import com.example.subscriptionservice.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository repository;

    @Autowired
    public SubscriptionServiceImpl(SubscriptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Subscription findByUserId(Integer userId) {
        return this.repository.findByUserId(userId);
    }
}
