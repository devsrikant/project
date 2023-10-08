package project.example.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.project.entity.Employee;
import project.example.project.repository.EmployeeRepository;
import project.example.project.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		return (List<Employee>) employeeRepository.findAll();
	}

	public Optional<Employee> getEmployeeById(Long id) {
		return employeeRepository.findById(id);
	}

	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(Long id, Employee updatedEmployee) {
		Optional<Employee> existingEmployeeOptional = employeeRepository.findById(id);
		if (existingEmployeeOptional.isPresent()) {
			Employee existingEmployee = existingEmployeeOptional.get();
			// Update the fields of the existing employee with the values from updatedEmployee
			existingEmployee.setName(updatedEmployee.getName());
			existingEmployee.setEmail(updatedEmployee.getEmail());
			existingEmployee.setPassword(updatedEmployee.getPassword());
			existingEmployee.setMobileNumber(updatedEmployee.getMobileNumber());
			existingEmployee.setDob(updatedEmployee.getDob());
			existingEmployee.setGender(updatedEmployee.getGender());
			existingEmployee.setAddress(updatedEmployee.getAddress());
			// Save the updated employee
			return employeeRepository.save(existingEmployee);
		} else {
			return null; // Handle not found
		}
	}


	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(Math.toIntExact(id));
	}
}
