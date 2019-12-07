package com.example.hr;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.example.hr.controller.EmployeeRestControllerTest;
import com.example.hr.service.EmployeeServiceTest;

@RunWith(Suite.class)
@SuiteClasses({ EmployeeRestControllerTest.class, EmployeeServiceTest.class })
public class AllTests {

}
