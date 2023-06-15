package com.example.homework2_13;

import com.example.homework2_13.services.DepartmentService;
import com.example.homework2_13.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartmentServiceTest {

    private EmployeeService employeeService;

    public DepartmentServiceTest(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @BeforeEach
    public void BeforeEach(){
        employeeService = new EmployeeService();
    }

    @Test
    public void getEmployeeByDeptTestAddition(){
//        assertEquals();
    }
}