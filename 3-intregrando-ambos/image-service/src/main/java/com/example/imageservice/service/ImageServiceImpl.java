package com.example.imageservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService{

    @Value("${image-url}")
    private String imageUrl;

    @Override
    public String getImage(String imageId) {
        return this.imageUrl;
    }
}
