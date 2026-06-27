package com.example.Employeeapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.Employeeapi.dto.EmployeeDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
@Autowired
private EmployeeRepository employeeRepository;

@GetMapping
public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
}

@GetMapping("/{id}")
public Employee getEmployeeById(@PathVariable Long id) {
    return employeeRepository.findById(id).orElse(null);
}

@PostMapping
public ResponseEntity<Employee> createEmployee(
        @Valid @RequestBody EmployeeDTO employeeDTO) {

    Employee employee = new Employee();

    employee.setName(employeeDTO.getName());
    employee.setDepartment(employeeDTO.getDepartment());
    employee.setSalary(employeeDTO.getSalary());

    Employee savedEmployee = employeeRepository.save(employee);

    return ResponseEntity.status(201).body(savedEmployee);
}

@PutMapping("/{id}")
public ResponseEntity<Employee> updateEmployee(
        @PathVariable Long id,
        @Valid @RequestBody EmployeeDTO employeeDTO) {

    Employee employee = employeeRepository.findById(id).orElse(null);

    if (employee == null) {
        return ResponseEntity.notFound().build();
    }

    employee.setName(employeeDTO.getName());
    employee.setDepartment(employeeDTO.getDepartment());
    employee.setSalary(employeeDTO.getSalary());

    Employee updatedEmployee = employeeRepository.save(employee);

    return ResponseEntity.ok(updatedEmployee);
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {

    if (!employeeRepository.existsById(id)) {
        return ResponseEntity.notFound().build();
    }

    employeeRepository.deleteById(id);

    return ResponseEntity.ok("Employee deleted successfully");
}


}
