package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserMessageProducer;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private UserMessageProducer producer;

    @Autowired

    private UserService userService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("me")
    public User me() {
        return new User(12L, "Bibhu", "Dash");
    }

    @GetMapping("users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping("/send")
    public String sendUser(@RequestBody User user) {
        producer.sendUserMessage(user);
        return "Message sent: " + user;
    }
}
