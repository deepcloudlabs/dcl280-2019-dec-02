package com.example.hr.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.hr.HrBackendApplication;
import com.example.hr.entity.Employee;
import com.example.hr.exception.EmployeeNotFound;
import com.example.hr.exception.ExistingEmployeeException;
import com.example.hr.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK, classes = HrBackendApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
public class EmployeeRestControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private EmployeeService employeeService;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void getEmployeeByIdentity_thenReturnJson() throws Exception {
		Employee jack = new Employee("12345678910", "Jack Bauer", 100_000);
		// Setup
		Mockito.when(employeeService.findByIdentity("12345678910")).thenReturn(jack);
		mockMvc.perform(get("/employees/12345678910")).andExpect(status().isOk())
				.andExpect(jsonPath("identity", is(jack.getIdentity())))
				.andExpect(jsonPath("fullname", is(jack.getFullname())))
				.andExpect(jsonPath("salary", is(jack.getSalary())));
	}

	@Test
	public void getEmployeeByIdentity_thenSendsBadRequest() throws Exception {
		// Setup
		Mockito.when(employeeService.findByIdentity("1")).thenThrow(EmployeeNotFound.class);
		mockMvc.perform(get("/employees/1")).andExpect(status().isBadRequest());
	}

	@Test
	public void createNewEmployee_thenSendsBadRequest() throws Exception {
		Employee jack = new Employee("11111111110", "Jack Bauer", 100_000);
		String json = objectMapper.writeValueAsString(jack);
		Mockito.when(employeeService.createEmployee(jack)).thenThrow(ExistingEmployeeException.class);
		mockMvc.perform(post("/employees").content(json).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isBadRequest());
	}

	@Test
	public void getEmployees_thenSendsOk() throws Exception {
		Employee jack = new Employee("11111111110", "Jack Bauer", 100_000);
		Employee kate = new Employee("21111111110", "Kate Austen", 200_000);
		Mockito.when(employeeService.findAll(0, 2)).thenReturn(Arrays.asList(jack, kate));
		mockMvc.perform(get("/employees?pageno=0&pagesize=2")).andExpect(status().isOk())
				.andExpect(jsonPath("$", Matchers.hasSize(2)))
				.andExpect(jsonPath("$[0].identity", is(jack.getIdentity())))
				.andExpect(jsonPath("$[1].identity", is(kate.getIdentity())));

	}

	@Test
	public void createNewEmployee_thenSendsOk() throws Exception {
		Employee jack = new Employee("10987654321", "Jack Bauer", 100_000);
		String json = objectMapper.writeValueAsString(jack);
		Mockito.when(employeeService.createEmployee(jack)).thenReturn(jack);
		mockMvc.perform(post("/employees").content(json).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andExpect(jsonPath("identity", is(jack.getIdentity())))
				.andExpect(jsonPath("fullname", is(jack.getFullname())))
				.andExpect(jsonPath("salary", is(jack.getSalary())));
		;
	}
}
