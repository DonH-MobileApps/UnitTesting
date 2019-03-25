package com.example.mvpdemo.Model.View.MainActivity;

import com.example.mvpdemo.Model.DataSource.local.EmployeeDatabaseHelper;

public class MainActivityPresenter {

    MainActivityContract contract;
    EmployeeDatabaseHelper employeeDatabaseHelper;

    public MainActivityPresenter(MainActivityContract contract) {
        this.contract = contract;
        employeeDatabaseHelper = new employeeDatabaseHelper();
    }



    public void initRecyclerView(){


    }
}
