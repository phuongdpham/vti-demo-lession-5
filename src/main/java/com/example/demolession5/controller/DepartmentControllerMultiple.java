package com.example.demolession5.controller;

import com.example.demolession5.service.DepartmentService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class DepartmentControllerMultiple {
    List<DepartmentService> services;

    @PostConstruct
    void init() {
        System.out.println(services.size());
    }

    public DepartmentControllerMultiple(List<DepartmentService> services) {
        this.services = services;
    }
}
