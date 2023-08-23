package com.example.demolession5.service;

import com.example.demolession5.model.Department;
import com.example.demolession5.model.DepartmentUpdateReq;

import java.util.List;

public interface DepartmentService {
    List<Department> getAll();

    Department getById(Integer id);

    Department create(Department department);

    Department update(Integer id, Department department);

    Department partialUpdate(Integer id, DepartmentUpdateReq department);

    void delete(Integer id);
}
