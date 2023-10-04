package com.sophatel;

class EmployeeAnnualSalary {
    private int employeeId;
    private String firstName;
    private String lastName;
    private int year;
    private double annualSalary;

    public EmployeeAnnualSalary(int employeeId, String firstName, String lastName, int year, double annualSalary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.annualSalary = annualSalary;
    }

    public EmployeeAnnualSalary() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYear() {
        return year;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }
}





