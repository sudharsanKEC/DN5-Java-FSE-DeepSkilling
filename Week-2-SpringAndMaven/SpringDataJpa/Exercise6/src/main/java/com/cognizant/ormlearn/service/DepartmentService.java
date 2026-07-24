package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public void employeesByDepartment(int deptId) throws Exception{
        Department department = departmentRepository.findById(deptId).orElseThrow(()-> new Exception("Invalid department Id"));
        List<Employee> employees = department.getEmployees();
        employees.forEach(System.out::println);
    }
}
