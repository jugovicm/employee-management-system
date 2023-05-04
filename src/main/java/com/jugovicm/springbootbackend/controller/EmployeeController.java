package com.jugovicm.springbootbackend.controller;

import com.jugovicm.springbootbackend.model.Employee;
import com.jugovicm.springbootbackend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    // inject dependencies
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //build create employee RESTapi
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee> ( employeeService.saveEmployee ( employee ), HttpStatus.CREATED );
    }

    @GetMapping
    // build get all employees RESTapi
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees ();
    }

    // build get employee by ID RESTapi
    //http://localhost:8080/api/employees/1
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId){
        return new ResponseEntity<Employee> (employeeService.getEmployeeById ( employeeId ), HttpStatus.OK);
    }

    // build update employee RESTapi
    //http://localhost:8080/api/employees/1
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        return new ResponseEntity<Employee> (employeeService.updateEmployee ( employee, id),HttpStatus.OK);
    }

    @DeleteMapping ("{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
        return new ResponseEntity<Employee> (employeeService.deleteEmployee(employee, id),HttpStatus.OK);
    }

}
