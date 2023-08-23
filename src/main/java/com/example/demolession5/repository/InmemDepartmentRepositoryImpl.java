package com.example.demolession5.repository;

import com.example.demolession5.model.Department;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * InmemDepartmentRepositoryImpl is a class that implements DepartmentRepository interface
 * and is annotated with @Repository annotation.
 */
@Repository
public class InmemDepartmentRepositoryImpl implements DepartmentRepository {
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
