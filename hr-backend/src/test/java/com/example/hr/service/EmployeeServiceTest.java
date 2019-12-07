package com.example.hr.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.hr.entity.Employee;
import com.example.hr.exception.EmployeeNotFound;
import com.example.hr.exception.ExistingEmployeeException;
import com.example.hr.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
	@Mock
	private EmployeeRepository employeeRepository;
	@InjectMocks
	private EmployeeService employeeService;

	@Test
	public void findByIdentity_existingEmployee() {
		Employee jack = new Employee("12345678910", "Jack Bauer", 100_000);
		// Setup
		Mockito.when(employeeRepository.findById("12345678910")).thenReturn(Optional.of(jack));
		// Exercise
		Employee found = employeeService.findByIdentity("12345678910");
		assertTrue(jack.equals(found));
	}

	@Test
	public void createEmployee_newEmployee() {
		Employee jack = new Employee("12345678910", "Jack Bauer", 100_000);
		// Setup
		Mockito.when(employeeRepository.save(jack)).thenReturn(jack);
		// Exercise
		Employee newEmployee = employeeService.createEmployee(jack);
		assertNotNull(newEmployee);
	}

	@Test(expected = ExistingEmployeeException.class)
	public void createEmployee_existingEmployee() {
		Employee jack = new Employee("12345678910", "Jack Bauer", 100_000);
		// Setup
		Mockito.when(employeeRepository.existsById(jack.getIdentity())).thenReturn(true);
		// Exercise
		Employee newEmployee = employeeService.createEmployee(jack);
		assertNotNull(newEmployee);
	}

	@Test
	public void updateEmployee_existingEmployee() {
		Employee jack = new Employee("12345678910", "Jack Bauer", 100_000);
		// Setup
		Mockito.when(employeeRepository.findById(jack.getIdentity())).thenReturn(Optional.of(jack));
		// Exercise
		Employee updatedEmployee = employeeService.updateEmployee(jack);
		assertNotNull(updatedEmployee);
		assertEquals(updatedEmployee.getSalary(), jack.getSalary(), 0.001);
	}

	@Test(expected = EmployeeNotFound.class)
	public void updateEmployee_nonexistingEmployee() throws Exception {
		Employee jack = new Employee("12345678910", "Jack Bauer", 100_000);
		// Setup
		Mockito.when(employeeRepository.findById("12345678910")).thenReturn(Optional.empty());
		// Exercise
		employeeService.updateEmployee(jack);
	}

	@Test
	public void deleteEmployee_existingEmployee() {
		Employee jack = new Employee("12345678910", "Jack Bauer", 100_000);
		// Setup
		Mockito.when(employeeRepository.findById(jack.getIdentity())).thenReturn(Optional.of(jack));
		// Exercise
		Employee deletedEmployee = employeeService.deleteByIdentity(jack.getIdentity());
		assertNotNull(deletedEmployee);
		assertEquals(deletedEmployee.getSalary(), jack.getSalary(), 0.001);
	}

	@Test(expected = EmployeeNotFound.class)
	public void deleteEmployee_nonexistingEmployee() throws Exception {
		Employee jack = new Employee("12345678910", "Jack Bauer", 100_000);
		// Setup
		Mockito.when(employeeRepository.findById("12345678910")).thenReturn(Optional.empty());
		// Exercise
		employeeService.deleteByIdentity(jack.getIdentity());
	}

	@Test(expected = EmployeeNotFound.class)
	public void findByIdentity_nonExistingEmployee() {
		// Setup
		Mockito.when(employeeRepository.findById("12345678910")).thenReturn(Optional.empty());
		// Exercise
		employeeService.findByIdentity("12345678910");
	}

	@SuppressWarnings("unchecked")
	@Test
	public void findAll_returnsTwoCustomers() {
		// Setup
		Employee jack = new Employee("12345678910", "Jack Bauer", 100_000);
		Employee kate = new Employee("10987654321", "Kate Austen", 200_000);
		Page<Employee> page = Mockito.mock(Page.class);
		Mockito.when(page.getContent()).thenReturn(Arrays.asList(jack, kate));
		Mockito.when(employeeRepository.findAll(PageRequest.of(0, 2))).thenReturn(page);
		// Exercise
		List<Employee> list = employeeService.findAll(0, 2);
		assertEquals(2, list.size());
		assertEquals(jack, list.get(0));
		assertEquals(kate, list.get(1));
	}
}
