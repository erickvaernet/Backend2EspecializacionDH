package com.example.subscriptionservice.service;

import com.example.subscriptionservice.model.Subscription;

public interface SubscriptionService {

    public Subscription findByUserId(Integer userId);
}
