package com.example.hr.service;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.hr.entity.Employee;
import com.example.hr.exception.EmployeeNotFound;
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
    	Mockito.when(employeeRepository.findById("12345678910"))
    	        .thenReturn(Optional.of(jack));
    	// Exercise
    	Employee found = employeeService.findByIdentity("12345678910");
    	assertTrue(jack.equals(found));    	
    }
    
	@Test(expected = EmployeeNotFound.class)
	public void findByIdentity_nonExistingEmployee() {
		// Setup
		Mockito.when(employeeRepository.findById("12345678910"))
		       .thenReturn(Optional.empty());
		// Exercise
		employeeService.findByIdentity("12345678910");
	}
	
	
}
