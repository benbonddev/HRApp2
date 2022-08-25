package com.service;

import com.model.Employee;
import com.model.Employees;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EmployeeService {

    /**
     * Create new employee
     */
    public Employee createNewEmployee(String firstName, String lastName, String email, String deptCode, String hireDate) {

        if (Employees.employees == null) {
            Employees.employees = new ArrayList<>();
        }

        Employee employee = new Employee();
        employee.setFIRST_NAME(firstName);
        employee.setLAST_NAME(lastName);
        employee.setEMAIL(email);
        employee.setDEPT_CODE(deptCode);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy", Locale.ENGLISH);
        employee.setHIRE_DATE(LocalDate.parse(hireDate, formatter));
        employee.setEMPLOYEE_ID(Employees.employees.size()+1);

        Employees.employees.add(employee);

        return employee;
    }

    /**
     * Find employees with anniversary
     */
    public List<Employee> getEmployeesWithAnniversary() {
        List<Employee> employees =  Employees.employees;

        List<Employee> employeesWithAnniversary = new ArrayList<>();

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getHIRE_DATE().getMonth() == LocalDate.now().getMonth()) {
                employeesWithAnniversary.add(employees.get(i));
            }
        }

        return  employeesWithAnniversary;
    }

}
