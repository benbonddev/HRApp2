package com.model;

import java.time.LocalDate;

public class Employee {

    private int EMPLOYEE_ID;
    private String FIRST_NAME;
    private String LAST_NAME;
    private String DEPT_CODE;
    private LocalDate HIRE_DATE;
    private String EMAIL;

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public int getEMPLOYEE_ID() {
        return EMPLOYEE_ID;
    }

    public void setEMPLOYEE_ID(int EMPLOYEE_ID) {
        this.EMPLOYEE_ID = EMPLOYEE_ID;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public String getDEPT_CODE() {
        return DEPT_CODE;
    }

    public void setDEPT_CODE(String DEPT_CODE) {
        this.DEPT_CODE = DEPT_CODE;
    }

    public LocalDate getHIRE_DATE() {
        return HIRE_DATE;
    }

    public void setHIRE_DATE(LocalDate HIRE_DATE) {
        this.HIRE_DATE = HIRE_DATE;
    }

}
