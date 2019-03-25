package com.example.mvpdemo.Model.View.MainActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mvpdemo.Model.Employee.Employee;
import com.example.mvpdemo.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainActivityContract{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void populateRecyclerView(ArrayList<Employee> employeeArrayList) {

    }
}
