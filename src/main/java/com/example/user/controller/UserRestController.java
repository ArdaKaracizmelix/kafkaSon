package com.example.user.controller;


import com.example.user.model.UserModel;
import com.example.user.service.UserService;
import kafka.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    UserService userService;
    KafkaProducer producer;

    @Autowired
    public UserRestController(UserService userService, KafkaProducer producer) {
        this.userService = userService;
        this.producer = producer;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody UserModel user) {
        userService.save(user);
        producer.send(user.getPhoneNumber());
        return ResponseEntity.ok("User added");
    }

}
