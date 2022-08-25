package com.view;

import com.model.Employee;
import com.service.EmployeeService;
import java.time.LocalDate;
import java.util.List;

import javax.swing.JOptionPane;

public class Menu {

    public static void displayMainMenu() {

        int choice = 0;

        do {
            choice = mainMenu();

            switch(choice) {
                case 1: createNewEmployee();
                    break;
                case 2: displayEmployeesWithAnniversary();
                    break;
                case 3: System.out.println("Goodbye!");
                break;

                default: JOptionPane.showMessageDialog(null, "Invalid choice! Unable to continue.");
                    break;
            }

        } while(choice < 3);  //end do while
    }

    /**
     * Get election menu selection from the user.
     *
     * @return menu selection
     */
    public static int mainMenu() {
        for(int attempt = 0; attempt < 3; attempt++) {
            String choice = JOptionPane.showInputDialog("\tMain Menu \n\n\tEnter your choice 1-2\n" +
                    " -1- Create Employee.\n"         +
                    " -2- Find Employee with Anniversary.\n" +
                    " -3- Go back to main menu\n\n");
            if(isValidChoice(Integer.parseInt(choice), 4)) {
                return Integer.parseInt(choice);
            }
        }
        return 0;
    }

    /**
     * Validate user input number
     *
     * @param choice
     * 			- selection number from the user
     * @param max
     * 			- selection should be less than this number
     * @return true if valid choice, otherwise false.
     */
    public static boolean isValidChoice(int choice, int max) {
        boolean isValid = !Character.isDigit(choice) && (choice > 0 & choice < max);
        if(!isValid) {
            JOptionPane.showMessageDialog(null, "Invalid option entered. Please re-enter valid selection.");
        }
        return isValid;
    }

    /**
     * New employee creation
     */
    public static void createNewEmployee() {

        String firstName = JOptionPane.showInputDialog("Enter First Name: ");
        String lastName = JOptionPane.showInputDialog("Enter Last Name: ");
        String email = JOptionPane.showInputDialog("Enter Email: ");
        String deptCode = JOptionPane.showInputDialog("Enter Department Code: ");
        String hireDate = JOptionPane.showInputDialog("Enter Hire Date: ");

        EmployeeService service = new EmployeeService();
        Employee employee = service.createNewEmployee(firstName, lastName, email, deptCode, hireDate);

        System.out.println("Employee ID: " + employee.getEMPLOYEE_ID());
        displayEmployeeInfo(employee, "");
    }

    /**
     * Display employee information
     *
     * @param employee
     * 			- employee object
     * @param msg
     * 			- is optional, any additional message.
     */
    private static void displayEmployeeInfo(Employee employee, String msg) {
        JOptionPane.showMessageDialog(null, "Employee Information\n\n"
                + "Full Name: " + employee.getFIRST_NAME() + " " + employee.getLAST_NAME() +"\n"
                + "Hire Date: " + employee.getHIRE_DATE() +"\n"
                + "Employee ID: " + employee.getEMPLOYEE_ID() +"\n\n"+msg);
    }

    /**
     * Display employees with anniversary
     *
     */
    private static void displayEmployeesWithAnniversary() {
        EmployeeService service = new EmployeeService();

        List<Employee> employees = service.getEmployeesWithAnniversary();

        boolean foundAnniversary = false;

        for(Employee emp : employees) {
            foundAnniversary = true;
            int years = LocalDate.now().getYear() - emp.getHIRE_DATE().getYear();
            displayEmployeeInfo(emp, years + " years with the company.");

        }

        if(!foundAnniversary) {
            JOptionPane.showMessageDialog(null, "No employee anniversary in this month.\n\n");
        }
    }


}
