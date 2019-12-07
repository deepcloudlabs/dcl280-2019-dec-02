package com.example.hr.repository;

import com.example.hr.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepository
        extends MongoRepository<Employee, String>,
        PagingAndSortingRepository<Employee, String> {
    List<Employee> findAllBySalaryGreaterThanEqual(double salary);
}
