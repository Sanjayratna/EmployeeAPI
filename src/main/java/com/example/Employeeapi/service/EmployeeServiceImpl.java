package com.example.Employeeapi.service;

import com.example.Employeeapi.Employee;
import com.example.Employeeapi.EmployeeRepository;
import com.example.Employeeapi.dto.EmployeeDTO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger logger =
            LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;

   @Override
public List<Employee> getAllEmployees() {

    logger.info("Fetching all employees");

    return employeeRepository.findAll();
}
   @Override
public Employee getEmployeeById(Long id) {

    logger.info("Fetching employee with ID: {}", id);

    return employeeRepository.findById(id).orElse(null);
}

   @Override
public Employee createEmployee(EmployeeDTO employeeDTO) {

    logger.info("Creating a new employee: {}", employeeDTO.getName());

    Employee employee = new Employee();

    employee.setName(employeeDTO.getName());
    employee.setDepartment(employeeDTO.getDepartment());
    employee.setSalary(employeeDTO.getSalary());

    Employee savedEmployee = employeeRepository.save(employee);

    logger.info("Employee created successfully with ID: {}", savedEmployee.getId());

    return savedEmployee;
}

    @Override
public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {

    logger.info("Updating employee with ID: {}", id);

    Employee employee = employeeRepository.findById(id).orElse(null);

    if (employee == null) {
        logger.warn("Employee not found with ID: {}", id);
        return null;
    }

    employee.setName(employeeDTO.getName());
    employee.setDepartment(employeeDTO.getDepartment());
    employee.setSalary(employeeDTO.getSalary());

    Employee updatedEmployee = employeeRepository.save(employee);

    logger.info("Employee updated successfully with ID: {}", id);

    return updatedEmployee;
}
   @Override
public boolean deleteEmployee(Long id) {

    logger.info("Deleting employee with ID: {}", id);

    if (!employeeRepository.existsById(id)) {

        logger.warn("Employee not found with ID: {}", id);

        return false;
    }

    employeeRepository.deleteById(id);

    logger.info("Employee deleted successfully with ID: {}", id);

    return true;
}
}