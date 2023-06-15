package com.example.homework2_13;

import com.example.homework2_13.exceptions.FullMapException;
import com.example.homework2_13.services.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.example.homework2_13.ConstantsSet.*;
import static org.junit.jupiter.api.Assertions.*;


public class EmployeeServiceTest {
    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        employeeService = new EmployeeService();
        employeeService.addEmployee(FULL_NAME_1, SALARY_1, DEPARTMENT_1);
    }

    @Test
    public void getEmployees() {
        Map<String, Employee> employeesTest = employeeService.getEmployees();

        assertNotNull(employeesTest);
        assertEquals(FULL_NAME_1, employeeService.getEmployees().get(FULL_NAME_1).getFullName());
        assertEquals(SALARY_1, employeeService.getEmployees().get(FULL_NAME_1).getSalary());
        assertEquals(DEPARTMENT_1, employeeService.getEmployees().get(FULL_NAME_1).getDept());
    }

    @Test
    public void addEmployeeTest() {
        assertTrue(employeeService.getEmployees().containsKey(FULL_NAME_1));

        assertTrue(employeeService.getEmployees().containsValue(EMPLOYEE1));

        assertEquals(EMPLOYEE1, employeeService.getEmployees().get(FULL_NAME_1));
        assertEquals(FULL_NAME_1, employeeService.getEmployees().get(FULL_NAME_1).getFullName());
        assertEquals(SALARY_1, employeeService.getEmployees().get(FULL_NAME_1).getSalary());
        assertEquals(DEPARTMENT_1, employeeService.getEmployees().get(FULL_NAME_1).getDept());
    }

    @Test
    public void addEmployeeTestException() {
        /**заполняем мапу до предела*/
        int keyCounter = 0;
        String keyFullName = "Имя";
        for (int i = 0; i < 7; i++) {
            keyCounter++;
            keyFullName += keyCounter;
            employeeService.getEmployees().put(keyFullName, new Employee(keyFullName, SALARY_1, DEPARTMENT_1));
        }

        assertThrows(FullMapException.class, () -> employeeService.addEmployee(FULL_NAME_2, SALARY_2, DEPARTMENT_2));
    }

    @Test
    public void removeEmployee(){
        employeeService.removeEmployee(FULL_NAME_1);
        assertFalse(employeeService.getEmployees().containsKey(FULL_NAME_1));
    }

    @Test
    public void changeEmployee(){
        employeeService.changeEmployee(FULL_NAME_1, FULL_NAME_2, SALARY_2, DEPARTMENT_2);
        assertFalse(employeeService.getEmployees().containsKey(FULL_NAME_1));
        assertTrue(employeeService.getEmployees().containsKey(FULL_NAME_2));
        assertEquals(13, employeeService.getEmployees().get(FULL_NAME_2).getId());
    }
}
