package com.aricenter.sport.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    @GetMapping("my-first-endpoint")
    String method(){
        return "My site";
    }
}
