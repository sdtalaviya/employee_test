package com.paypal.bfs.test.employeeserv.transformer;

import org.springframework.stereotype.Component;

import com.paypal.bfs.test.employeeserv.api.model.Address;
import com.paypal.bfs.test.employeeserv.api.model.DateOfBirth;
import com.paypal.bfs.test.employeeserv.api.model.Employee;
import com.paypal.bfs.test.employeeserv.api.model.AddressEntity;
import com.paypal.bfs.test.employeeserv.api.model.EmployeeEntity;

@Component
public class EmployeeTransformer {

    public static Employee entityToModel(EmployeeEntity empEntity) {
        Employee employee = new Employee();
        employee.setId(empEntity.getId());
        employee.setFirstName(empEntity.getFirstName());
        employee.setLastName(empEntity.getLastName());

        DateOfBirth dob = new DateOfBirth();
        dob.setDate(empEntity.getDobDay());
        dob.setMonth(empEntity.getDobMonth());
        dob.setYear(empEntity.getDobYear());
        employee.setDateOfBirth(dob);

        Address address = new Address();
        AddressEntity addressEntity = empEntity.getAddress();
        address.setLine1(addressEntity.getLine1());
        address.setLine2(addressEntity.getLine2());
        address.setCity(addressEntity.getCity());
        address.setState(addressEntity.getState());
        address.setCountry(addressEntity.getCountry());
        address.setZipCode(addressEntity.getZipCode());
        employee.setAddress(address);

        return employee;
    }

    public static EmployeeEntity modelToEntity(Employee employee) {
        EmployeeEntity empEntity = new EmployeeEntity();
        if (employee.getId() != null) {
            // ignoring for post calls
            empEntity.setId(employee.getId());
        }
        empEntity.setFirstName(employee.getFirstName());
        empEntity.setLastName(employee.getLastName());

        DateOfBirth dob = employee.getDateOfBirth();
        empEntity.setDobDay(dob.getDate());
        empEntity.setDobMonth(dob.getMonth());
        empEntity.setDobYear(dob.getYear());

        AddressEntity addressEntity = new AddressEntity();
        Address address = employee.getAddress();
        addressEntity.setLine1(address.getLine1());
        addressEntity.setLine2(address.getLine2());
        addressEntity.setCity(address.getCity());
        addressEntity.setState(address.getState());
        addressEntity.setCountry(address.getCountry());
        addressEntity.setZipCode(address.getZipCode());
        empEntity.setAddress(addressEntity);

        return empEntity;
    }
}
