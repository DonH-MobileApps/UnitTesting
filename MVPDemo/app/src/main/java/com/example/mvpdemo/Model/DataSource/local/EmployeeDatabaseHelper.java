package com.example.mvpdemo.Model.DataSource.local;

import android.view.LayoutInflater;

import com.example.mvpdemo.Model.Employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDatabaseHelper {
    private ArrayList<Employee> employeeDatabase;

    public EmployeeDatabaseHelper() {
        employeeDatabase = initEmployeeList();

    }

    public void addEmployee(Employee employee) {
        employeeDatabase.add(employee);

    }

    public ArrayList<Employee> getAllEmployees(){
        return employeeDatabase;

    }


    private static ArrayList<Employee> initEmployeeList() {
        ArrayList<Employee> employeeArrayList = new ArrayList<>();

        employeeArrayList.add(new Employee("Mike", "40.00", "April 1, 2000", true, "IT"));
        employeeArrayList.add(new Employee("Kobe", "15.00", "April 5, 2000", true, "IT"));
        employeeArrayList.add(new Employee("LeBron", "18.00", "April 6, 2000", true, "IT"));
        employeeArrayList.add(new Employee("Shaq", "23.00", "April 13, 2000", true, "IT"));
        employeeArrayList.add(new Employee("Allen", "34.00", "April 17, 2000", true, "IT"));
        employeeArrayList.add(new Employee("Wilt", "22.00", "April 21, 2000", true, "IT"));
        employeeArrayList.add(new Employee("James", "17.00", "April 4, 2000", true, "IT"));

        return employeeArrayList;
    }

}
