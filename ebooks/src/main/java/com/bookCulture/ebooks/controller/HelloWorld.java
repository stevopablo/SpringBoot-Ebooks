package com.bookCulture.ebooks.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class HelloWorld {

    @GetMapping("/home")
    public String hello(){
        return "Hello from Spring Boot";
    }
}
