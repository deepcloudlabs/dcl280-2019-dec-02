package com.example.hr.service;

import static java.util.Objects.nonNull;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.hr.entity.Employee;
import com.example.hr.exception.EmployeeNotFound;
import com.example.hr.exception.ExistingEmployeeException;
import com.example.hr.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public List<Employee> findAll(int no, int size) {
		PageRequest pageable = PageRequest.of(no, size);
		Page<Employee> employees = employeeRepository.findAll(pageable);
		return employees.getContent();
	}

	public Employee findByIdentity(String identity) {
		final Optional<Employee> employee = employeeRepository.findById(identity);
		if (employee.isPresent())
			return employee.get();
		throw new EmployeeNotFound("Employee is not found", "employeeNotFound", "4aee7c2e-d1f4-4276-b46a-c3853a2b0010");
	}

	public Employee createEmployee(Employee employee) {
		final String identity = employee.getIdentity();
		if (employeeRepository.existsById(identity))
			throw new ExistingEmployeeException("Employee already exists!", "existingEmployee",
					"4fcc0254-0c98-43be-82c7-7a381e345635");
		return employeeRepository.save(employee);
	}

	public Employee updateEmployee(Employee employee) {
		final String identity = employee.getIdentity();
		Optional<Employee> emp = employeeRepository.findById(identity);
		if (!emp.isPresent())
			throw new EmployeeNotFound("Employee is not found", "employeeNotFound",
					"52ed3bfd-d81a-4bb1-bc58-182382469f96");
		Employee managedEmployee = emp.get();
		String photo = employee.getPhoto();
		if (nonNull(photo))
			managedEmployee.setPhoto(photo);
		managedEmployee.setSalary(employee.getSalary());
		String fullname = employee.getFullname();
		if (nonNull(fullname))
			managedEmployee.setFullname(fullname);
		employeeRepository.save(managedEmployee);
		return managedEmployee;
	}

	public Employee deleteByIdentity(String identity) {
		Optional<Employee> emp = employeeRepository.findById(identity);
		if (!emp.isPresent())
			throw new EmployeeNotFound("Employee is not found", "employeeNotFound",
					"82c8eb91-8abc-4bb3-96d8-48828babb7ce");
		Employee employee = emp.get();
		employeeRepository.delete(employee);
		return employee;
	}
}
