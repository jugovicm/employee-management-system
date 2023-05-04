package com.jugovicm.springbootbackend.service;

import com.jugovicm.springbootbackend.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(long id);
    Employee updateEmployee(Employee employee, long id);
    Employee deleteEmployee(Employee employee, long id);
}
