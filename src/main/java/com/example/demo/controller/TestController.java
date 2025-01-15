package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @GetMapping("me")
    public User me(){
        return new User(12L,"Bibhu","Dash");
    }
}
