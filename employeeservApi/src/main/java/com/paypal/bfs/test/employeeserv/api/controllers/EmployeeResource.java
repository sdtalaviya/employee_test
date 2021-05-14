package com.paypal.bfs.test.employeeserv.api.controllers;

import java.util.List;
import javax.validation.Valid;

import com.paypal.bfs.test.employeeserv.api.model.Employee;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Interface for employee resource operations.
 */
public interface EmployeeResource {

    /**
     * Retrieves the {@link Employee} resource by id.
     *
     * @param id employee id.
     * @return {@link Employee} resource.
     */
    @GetMapping("/v1/bfs/employees/{id}")
    ResponseEntity<Employee> employeeGetById(@PathVariable("id") String id);

    @DeleteMapping("/v1/bfs/employees/{id}")
    ResponseEntity<Employee> deleteEmployee(@PathVariable("id") String id);

    @GetMapping("/v1/bfs/employees")
    ResponseEntity<List<Employee>> listEmployees();

    @PostMapping("/v1/bfs/employees")
    ResponseEntity<Employee> saveEmployee(@RequestBody Employee newEmployee);
}
