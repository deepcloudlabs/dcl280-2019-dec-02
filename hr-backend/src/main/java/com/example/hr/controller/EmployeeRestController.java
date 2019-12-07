package com.example.hr.controller;

import java.util.List;

import javax.validation.constraints.Pattern;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.hr.entity.Employee;
import com.example.hr.service.EmployeeService;

// http://localhost:9101/hr/api/v1/employees
@RestController
@RequestMapping("employees")
@RequestScope
@CrossOrigin
@Validated
public class EmployeeRestController {
	private EmployeeService employeeService;

	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// GET http://localhost:9101/hr/api/v1/employees?pageno=2&pagesize=25
	@GetMapping(params = { "pagesize", "pageno" })
	public List<Employee> getAllEmployees(
			@RequestParam(name = "pagesize", required = false, defaultValue = "10") int pagesize,
			@RequestParam(name = "pageno", required = false, defaultValue = "1") int pageno) {
		return employeeService.findAll(pageno, pagesize);
	}

	// GET http://localhost:9101/hr/api/v1/employees/12345678910
	@GetMapping("{identity}")
	public Employee getEmployeeByIdentity(
			@PathVariable("identity") @Validated @Pattern(regexp = "\\d{11}") String identity) {
		return employeeService.findByIdentity(identity);
	}

	@DeleteMapping("{identity}")
	public Employee removeEmployeeByIdentity(@PathVariable("identity") String identity) {
		return employeeService.deleteByIdentity(identity);
	}

	@PostMapping
	public Employee addEmployee(@RequestBody @Validated Employee employee) {
		return employeeService.createEmployee(employee);
	}

	@PutMapping
	public Employee updateEmployee(@RequestBody @Validated Employee employee) {
		return employeeService.updateEmployee(employee);
	}
}
