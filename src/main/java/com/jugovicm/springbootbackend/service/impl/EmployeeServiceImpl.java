package com.jugovicm.springbootbackend.service.impl;

import com.jugovicm.springbootbackend.exception.ResourceNotFoundException;
import com.jugovicm.springbootbackend.model.Employee;
import com.jugovicm.springbootbackend.repository.EmployeeRepository;
import com.jugovicm.springbootbackend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        //save to DB
        return employeeRepository.save ( employee );
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll ();
    }

    @Override
    public Employee getEmployeeById(long id) {
        /*Optional<Employee> employee = employeeRepository.findById ( id );
        if(employee.isPresent ()){
            return employee.get ();
        }else{
            throw new ResourceNotFoundException ( "Employee","Id", id );
        }*/
        return employeeRepository.findById ( id ).orElseThrow (()->
                new ResourceNotFoundException ( "Employee", "Id", id ));
    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {
        //check if employee with given id exist or not
        Employee existingEmployee = employeeRepository.findById ( id ).orElseThrow (()->
                new ResourceNotFoundException ( "Employee", "Id", id ));
        existingEmployee.setFirstName ( employee.getFirstName () );
        existingEmployee.setLastName ( employee.getLastName () );
        existingEmployee.setEmail ( employee.getEmail () );
        // save existing employee
        employeeRepository.save ( existingEmployee );
        return existingEmployee;
    }

    @Override
    public Employee deleteEmployee(Employee employee, long id) {
        //check if employee with given id exist or not
        Employee existingEmployee = employeeRepository.findById ( id ).orElseThrow (()->
                new ResourceNotFoundException ( "Employee", "Id", id ));
        // save existing employee
        employeeRepository.delete ( existingEmployee);
        return existingEmployee;
    }
}
