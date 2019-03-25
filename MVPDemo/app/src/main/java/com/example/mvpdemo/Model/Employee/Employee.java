package com.example.mvpdemo.Model.Employee;

public class Employee {
    private String employeeName;
    private String employeePayRate;
    private String employeeHireDate;
    private boolean isHourly;
    private String employeeDepartment;


    public Employee(String employeeName) {
    }

    public Employee(String employeeName, String employeePayRate,
                    String employeeHireDate, boolean isHourly, String employeeDepartment) {
        this.employeeName = employeeName;
        this.employeePayRate = employeePayRate;
        this.employeeHireDate = employeeHireDate;
        this.isHourly = isHourly;
        this.employeeDepartment = employeeDepartment;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePayRate() {
        return employeePayRate;
    }

    public void setEmployeePayRate(String employeePayRate) {
        this.employeePayRate = employeePayRate;
    }

    public String getEmployeeHireDate() {
        return employeeHireDate;
    }

    public void setEmployeeHireDate(String employeeHireDate) {
        this.employeeHireDate = employeeHireDate;
    }

    public boolean isHourly() {
        return isHourly;
    }

    public void setHourly(boolean hourly) {
        isHourly = hourly;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }
}
