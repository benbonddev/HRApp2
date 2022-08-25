package com.stepdefs;

import com.model.Employees;
import com.service.EmployeeService;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import javax.swing.*;

import static org.testng.Assert.assertTrue;

public class Employee_StepDefs {

    @Given("^I create new employee with \"([^\"]*)\" month$")
    public void iCreateNewEmployeeWithMonth(String month) {
        String firstName = "Mike";
        String lastName = "Smith";
        String email = "mikesmith@me.com";
        String deptCode = "ES2000";
        String hireDate = month;

        EmployeeService service = new EmployeeService();
        service.createNewEmployee(firstName, lastName, email, deptCode, hireDate);
    }

    @Then("^New employee is stored in database\\.$")
    public void newEmployeeIsStoredInDatabase() {
        assertTrue(Employees.employees.size()  > 0, "New employee crated.");
    }


    @Then("^Employee with anniversary is found$")
    public void employeeWithAnniversaryIsFound() {
        EmployeeService service = new EmployeeService();
        assertTrue(service.getEmployeesWithAnniversary().size()  > 0, "Employee with anniversary is found.");
    }

    @Then("^Employees with anniversary should not be found$")
    public void employeesWithAnniversaryShouldNotBeFound() {
        EmployeeService service = new EmployeeService();
        assertTrue(service.getEmployeesWithAnniversary().size()  == 0, "Employee with anniversary is not found.");
    }

}
