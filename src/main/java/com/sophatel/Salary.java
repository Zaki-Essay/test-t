package com.sophatel;

class Salary {
    private int employeeId;
    private int year;
    private int month;
    private double monthlySalary;

    public Salary(int employeeId, int year, int month, double monthlySalary) {
        this.employeeId = employeeId;
        this.year = year;
        this.month = month;
        this.monthlySalary = monthlySalary;
    }

    public Salary() {
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

}
