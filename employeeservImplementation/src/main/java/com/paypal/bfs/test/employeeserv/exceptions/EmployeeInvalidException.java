package com.paypal.bfs.test.employeeserv.exceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeInvalidException extends RuntimeException {

    private List<String> errors;

    private static final long serialVersionUID = 1L;

    public EmployeeInvalidException(String mesage, Throwable t) {
        super(mesage, t);
    }

    public EmployeeInvalidException(List<String> errors, String mesage) {
        super(mesage);
        this.errors = new ArrayList<String>(errors);
    }
}
