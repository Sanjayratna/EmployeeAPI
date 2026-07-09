package com.example.Employeeapi.service;

import com.example.Employeeapi.Employee;
import com.example.Employeeapi.EmployeeRepository;
import com.example.Employeeapi.dto.EmployeeDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Test
    void testGetAllEmployees() {

        Employee employee = new Employee("Ravi", "HR", 40000);

        when(employeeRepository.findAll()).thenReturn(List.of(employee));

        List<Employee> employees = employeeService.getAllEmployees();

        assertEquals(1, employees.size());
        assertEquals("Ravi", employees.get(0).getName());
    }
    @Test
void testGetEmployeeById() {

    Employee employee = new Employee("John", "IT", 50000);
    employee.setId(1L);

    when(employeeRepository.findById(1L))
            .thenReturn(java.util.Optional.of(employee));

    Employee foundEmployee = employeeService.getEmployeeById(1L);

    assertEquals("John", foundEmployee.getName());
    assertEquals("IT", foundEmployee.getDepartment());
    assertEquals(50000, foundEmployee.getSalary());
}
@Test
void testCreateEmployee() {

    EmployeeDTO employeeDTO = new EmployeeDTO();
    employeeDTO.setName("Sanjay");
    employeeDTO.setDepartment("Developer");
   employeeDTO.setSalary(60000.0);

    Employee employee = new Employee("Sanjay", "Developer", 60000);

    when(employeeRepository.save(org.mockito.ArgumentMatchers.any(Employee.class)))
            .thenReturn(employee);

    Employee savedEmployee = employeeService.createEmployee(employeeDTO);

    assertEquals("Sanjay", savedEmployee.getName());
    assertEquals("Developer", savedEmployee.getDepartment());
   assertEquals(60000.0, savedEmployee.getSalary());
}
}