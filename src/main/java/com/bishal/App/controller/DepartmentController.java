package com.bishal.App.controller;

import com.bishal.App.entity.Department;
import com.bishal.App.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department) {

        return service.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {
        return service.getAllDepartments();

    }

    @GetMapping("/department/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return service.getDepartmentById(id);
    }

    @DeleteMapping("/department/{id}")
    public String deleteDepartmentById(@PathVariable Long id) {
        return service.deleteDepartmentById(id);
    }

    @PutMapping("/department/{id}")
    public Department updateDepartmentById(@PathVariable Long id, @RequestBody Department department) {
        return service.updateDepartmentById(id, department);
    }

    @GetMapping("/department/name/{name}")
    public Department getDepartmentByName(@PathVariable String name) {
        return service.getDepartmentByName(name);

    }

}
