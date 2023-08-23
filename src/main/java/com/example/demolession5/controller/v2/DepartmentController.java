package com.example.demolession5.controller.v2;

import com.example.demolession5.model.Address;
import com.example.demolession5.model.Department;
import com.example.demolession5.model.DepartmentUpdateReq;
import com.example.demolession5.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("api/v2/departments")
public class DepartmentController {
    // DepartmentService bean is injected by Spring
    DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    /**
     * getAll() method returns a list of Department objects.
     * @return a list of Department objects.
     * breaking change --> versioning
     */
    @GetMapping
    public List<Department> getAll() {
        return service.getAll();
    }
    

    /**
     * getById() method returns a Department object by id. /departments/{id} is the endpoint.
     * @param id is the id of the Department object.
     * @return a Department object.
     */
    @GetMapping("{id}")
    public Department getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }

    /**
     * generic
     * @param id is the id of the Department object.
     * @return a Set of Address objects.
     */
    @GetMapping("{id}/addresses")
    public Set<Address> getAddressById(@PathVariable("id") Integer id) {
        var department = service.getById(id);

        if (department == null) {
            // throw not found exception
            // business exception --> tu dinh ngia, phu thuoc vao logic cua business
            // DepartmentNotFoundException
            // AddressNotFoundException
            return Collections.emptySet();
        }

        return department.getAddress();
    }

    @PostMapping
    public Department create(@RequestBody Department department) {
        return service.create(department);
    }

    // replace the old department with the new department --> PUT
    // partial update some fields of the department --> PATCH

    @PutMapping("{id}")
    public Department update(@PathVariable("id") Integer id, @RequestBody Department department) {
        return service.update(id, department);
    }

    @PatchMapping("{id}")
    public Department partialUpdate(@PathVariable("id") Integer id, @RequestBody DepartmentUpdateReq department) {
        return service.partialUpdate(id, department);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
