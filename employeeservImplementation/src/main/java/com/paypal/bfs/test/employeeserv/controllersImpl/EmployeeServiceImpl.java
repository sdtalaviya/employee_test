package com.paypal.bfs.test.employeeserv.controllersImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.paypal.bfs.test.employeeserv.api.services.EmployeeService;
import com.paypal.bfs.test.employeeserv.api.model.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.api.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepo;

    public EmployeeEntity saveEmployee(EmployeeEntity employee) {
        return employeeRepo.save(employee);
    }

    public List<EmployeeEntity> listEmployees() {
        return employeeRepo.findAll();
    }

    public Optional<EmployeeEntity> getEmployee(int id) {
        return employeeRepo.findById(id);
    }

    public Optional<EmployeeEntity> getEmployee(EmployeeEntity employee) {
        Example<EmployeeEntity> example = Example.of(employee);
        return employeeRepo.findOne(example);
    }

    public void deleteEmployee(int id) {
        employeeRepo.deleteById(id);
    }
}
