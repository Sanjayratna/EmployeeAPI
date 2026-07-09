package com.example.Employeeapi.service;

import com.example.Employeeapi.Employee;
import com.example.Employeeapi.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployees();

    Employee getEmployeeById(Long id);

    Employee createEmployee(EmployeeDTO employeeDTO);

    Employee updateEmployee(Long id, EmployeeDTO employeeDTO);

    boolean deleteEmployee(Long id);
}