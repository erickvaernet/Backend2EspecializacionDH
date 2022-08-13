package com.example.accountservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class AcoountController {
    @Value("${server.port}")
    private String port;
    @Value("${message}")
    private String message;
    @Value("${global-message}")
    private String globalMessage;


    @GetMapping("/properties")
    public Map<String, String> getProperties() {
        Map<String,String> props= new HashMap<>();
        props.put("port",this.port);
        props.put("message",this.message);
        props.put("global-message",this.globalMessage);
        return props;
    }
}
