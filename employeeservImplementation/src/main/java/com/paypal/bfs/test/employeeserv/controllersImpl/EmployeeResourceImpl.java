package com.paypal.bfs.test.employeeserv.controllersImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import com.paypal.bfs.test.employeeserv.api.controllers.EmployeeResource;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.exceptions.EmployeeInvalidException;
import com.paypal.bfs.test.employeeserv.api.model.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.transformer.EmployeeTransformer;
import com.paypal.bfs.test.employeeserv.util.EmployeeValidationsUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

    @Autowired EmployeeServiceImpl employeeServiceImpl;

    @Autowired EmployeeTransformer employeeTransformer;

    @Override
    public ResponseEntity<Employee> employeeGetById(String id) {
        Employee employee = null;
        EmployeeEntity empEntity = employeeServiceImpl.getEmployee(Integer.parseInt(id.trim())).get();
        employee = employeeTransformer.entityToModel(empEntity);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Employee> deleteEmployee(String id) {
        employeeServiceImpl.deleteEmployee(Integer.parseInt(id.trim()));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @Transactional
    public ResponseEntity<Employee> saveEmployee(Employee newEmployee) {
        List<String> errors = EmployeeValidationsUtil.isValid(newEmployee);
        if (errors.size() == 0) {
            EmployeeEntity employeeEntity = employeeTransformer.modelToEntity(newEmployee);
            try {
                employeeEntity = employeeServiceImpl.getEmployee(employeeEntity).get();
            } catch(NoSuchElementException e) {
                employeeEntity = employeeServiceImpl.saveEmployee(employeeEntity);
            }
            return new ResponseEntity<>(employeeTransformer.entityToModel(employeeEntity), HttpStatus.CREATED);
        } else {
            throw new EmployeeInvalidException(errors, "Invalid Employee details");
        }
    }

    @Override
    public ResponseEntity<List<Employee>> listEmployees() {
        List<Employee> employees = new ArrayList<>();
        List<EmployeeEntity> empEntities = employeeServiceImpl.listEmployees();
        for (EmployeeEntity employeeEntity: empEntities) {
            employees.add(employeeTransformer.entityToModel(employeeEntity));
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}
