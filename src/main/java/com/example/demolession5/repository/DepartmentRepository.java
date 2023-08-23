package com.example.demolession5.repository;

import com.example.demolession5.model.Department;

import java.util.List;

public interface DepartmentRepository {
    List<Department> getAll();

    Department getById(Integer id);

    Department create(Department department);

    void delete(Integer id);
}
