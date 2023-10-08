package project.example.project.entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotBlank(message = "Name is required")
	@Size(min = 3, max = 20, message = "Name must be between 3 and 20 characters")
	@Pattern(regexp = "^[a-zA-Z]+$", message = "Name must contain only letters")
	private String name;

	@NotBlank(message = "Password is required")
	@Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
	private String password;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;

	@Size(min = 10, max = 10, message = "Phone number must be 10 digits")
	@Pattern(regexp = "^[0-9]+$", message = "Phone number must contain only digits")
	private String phone;

	@NotBlank(message = "Address is required")
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Address must contain only alphanumeric characters")
	private String address;
	private long mobileNumber;
	private Date dob;
	private String gender;


}
