package project.example.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.example.project.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

	Optional<Employee> findById(Long employeeId);

}
