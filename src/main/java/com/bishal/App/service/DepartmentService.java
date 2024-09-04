package com.bishal.App.service;

import com.bishal.App.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long id);

    String deleteDepartmentById(Long id);

    Department updateDepartmentById(Long id, Department department);

    Department getDepartmentByName(String name);
}
