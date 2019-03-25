package com.example.mvpdemo.Model.View.MainActivity;

import com.example.mvpdemo.Model.Employee.Employee;

import java.util.ArrayList;

public interface MainActivityContract {
    void populateRecyclerView(ArrayList<Employee> employeeArrayList);


}
