package project.example.project.service;

import project.example.project.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(Long id);

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Long id, Employee updatedEmployee);

    void deleteEmployee(Long id);
}
