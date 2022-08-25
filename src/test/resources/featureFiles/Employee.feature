Feature: Employee Anniversary

  Scenario: 01 - Verify employees with no anniversary should not display when months don't match
    Given I create new employee with "02/11/1979" month
    Then Employees with anniversary should not be found

  Scenario: 02 - Verify new employee account should be created when HR submits new employee
    Given I create new employee with "08/11/1989" month
    Then New employee is stored in database.

  Scenario: 03 - Verify employees with anniversary should display with current month
    Given I create new employee with "08/11/1989" month
    Then Employee with anniversary is found

