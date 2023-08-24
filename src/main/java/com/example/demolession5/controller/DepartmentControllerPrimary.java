package com.example.demolession5.controller;

import com.example.demolession5.service.DepartmentService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentControllerPrimary {

    DepartmentService service;

    public DepartmentControllerPrimary(DepartmentService service) {
        this.service = service;
    }
}
