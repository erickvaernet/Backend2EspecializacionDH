package com.example.subscriptionservice.repository;

import com.example.subscriptionservice.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription,Integer> {

    public Subscription findByUserId(Integer userId);


}
