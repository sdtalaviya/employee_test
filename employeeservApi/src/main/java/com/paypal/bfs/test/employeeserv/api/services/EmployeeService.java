package com.paypal.bfs.test.employeeserv.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;

import com.paypal.bfs.test.employeeserv.api.model.EmployeeEntity;

public interface EmployeeService {
    public EmployeeEntity saveEmployee(EmployeeEntity employee);

    public List<EmployeeEntity> listEmployees();

    public Optional<EmployeeEntity> getEmployee(int id);

    public Optional<EmployeeEntity> getEmployee(EmployeeEntity employee);

    public void deleteEmployee(int id);
}
