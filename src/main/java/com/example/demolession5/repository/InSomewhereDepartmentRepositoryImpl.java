package com.example.demolession5.repository;

import com.example.demolession5.model.Department;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class InSomewhereDepartmentRepositoryImpl implements DepartmentRepository {
    ConcurrentMap<Integer, Department> departments = new ConcurrentHashMap<>();
    @Override
    public List<Department> getAll() {
        return departments.values().stream().toList();
    }

    @Override
    public Department getById(Integer id) {
        return departments.get(id);
    }

    @Override
    public Department create(Department department) {
        departments.put(department.getId(), department);

        return departments.get(department.getId());
    }

    @Override
    public void delete(Integer id) {
        departments.remove(id);
    }
}
