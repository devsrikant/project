package project.example.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import project.example.project.entity.Employee;
import project.example.project.repository.EmployeeRepository;
import project.example.project.service.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class HomeController {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public String index() {
		return "Welcome to spring boot CRUD Application!!!";
	}

	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Optional<Employee> employee = employeeService.getEmployeeById(id);
		return employee.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee createdEmployee = employeeService.createEmployee(employee);
		return ResponseEntity.ok(createdEmployee);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
		Employee updated = employeeService.updateEmployee(id, updatedEmployee);
		return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}
}



