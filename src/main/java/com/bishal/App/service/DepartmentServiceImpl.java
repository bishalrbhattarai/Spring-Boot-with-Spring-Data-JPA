package com.bishal.App.service;

import com.bishal.App.entity.Department;
import com.bishal.App.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService{
        @Autowired
       private DepartmentRepository repository;

    @Override
    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public String deleteDepartmentById(Long id) {
try{
            repository.deleteById(id);

    return "Department with ID :"+id+" deleted successfully!";
}catch(Exception e){
    return "Could not delete";

}
    }

    @Override
    public Department updateDepartmentById(Long id, Department department) {
        Department depDB = repository.findById(id).get();

                if(!depDB.getDepartmentAddress().equals(department.getDepartmentAddress()) &&  department.getDepartmentAddress()!=null){
                        depDB.setDepartmentAddress(department.getDepartmentAddress());
                }

                if(!depDB.getDepartmentName().equals(department.getDepartmentName()) &&  department.getDepartmentName()!=null  ){
                    depDB.setDepartmentName(department.getDepartmentName());
                }

                if(!depDB.getDepartmentCode().equals(department.getDepartmentCode()) &&  department.getDepartmentCode()!=null ){
                    depDB.setDepartmentCode(department.getDepartmentCode());
                }

                return repository.save(depDB);

    }

    @Override
    public Department getDepartmentByName(String name) {

       return repository.findByDepartmentName(name);

    }
}
