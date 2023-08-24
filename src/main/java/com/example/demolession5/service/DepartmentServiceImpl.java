package com.example.demolession5.service;

import com.example.demolession5.model.Department;
import com.example.demolession5.model.DepartmentUpdateReq;
import com.example.demolession5.repository.DepartmentRepository;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {
    DepartmentRepository repository;

    public DepartmentServiceImpl(DepartmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Department> getAll() {
        return repository.getAll();
    }

    @Override
    public Department getById(Integer id) {
        var department = repository.getById(id);

        if (department == null) { //stacktrace
            throw new RuntimeException("Department not found");
        }

        return department;
    }

    @Override
    public Department create(Department department) {
        return repository.create(department);
    }

    @Override
    public Department update(Integer id, Department department) {
        // find department by id
        var departmentInDb = getById(id);
        // replace by new department
        department.setId(departmentInDb.getId());
        // save to repository
        return repository.create(department);
    }

    @Override
    public Department partialUpdate(Integer id, DepartmentUpdateReq department) {
        // find department by id
        var departmentInDb = getById(id);

        // update department by not null fields
        if (department.getName() != null) {
            departmentInDb.setName(department.getName());
        }

        if (department.getDescription() != null) {
            departmentInDb.setDescription(department.getDescription());
        }
        // save to repository
        return repository.create(departmentInDb);
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }
}
