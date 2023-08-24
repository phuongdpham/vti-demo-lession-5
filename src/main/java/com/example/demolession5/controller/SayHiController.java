package com.example.demolession5.controller;

import com.example.demolession5.service.SayHiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/say-hi")
public class SayHiController {
    SayHiService sayHiService;

    public SayHiController(SayHiService sayHiService) {
        this.sayHiService = sayHiService;
    }

    @GetMapping
    public String sayHi() {
        return sayHiService.sayHi();
    }
}
