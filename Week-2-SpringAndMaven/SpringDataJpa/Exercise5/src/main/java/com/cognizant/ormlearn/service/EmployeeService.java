package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void getEmployee(int id) throws Exception{
        Employee employee = employeeRepository.findById(id).orElseThrow(()->new Exception("Employee doesn't exist"));
        System.out.println("Called");
        System.out.println(employee.toString());
        System.out.println(employee.getDepartment().toString());
    }
}
