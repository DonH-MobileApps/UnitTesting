package com.example.employeedatabase;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayFragment extends Fragment {

     RecyclerView recyclerView;
     RecyclerView.Adapter mAdapter;
     RecyclerView.LayoutManager layoutManager;

    TextView tvDisplayName, tvDisplayBirthday, tvDisplayWage, tvDisplayHireDate;
    ImageView ivEmpImage;

    EmployeeDatabaseHelper employeeDatabaseHelper;

    public DisplayFragment() {

    }

    public DisplayFragment newInstance() {
        DisplayFragment fragment = new DisplayFragment();
        return fragment;

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.display_fragment, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        tvDisplayName = view.findViewById(R.id.tvEmpName);
        tvDisplayBirthday = view.findViewById(R.id.tvEmpBirthday);
        tvDisplayWage = view.findViewById(R.id.tvEmpWage);
        tvDisplayHireDate = view.findViewById(R.id.etHireDate);
        ivEmpImage = view.findViewById(R.id.ivEmpImage);

        recyclerView = view.findViewById(R.id.rvFrmDisplay);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Employee> employeeList =
                employeeDatabaseHelper.getAllEmployeesFromDatabase();

       mAdapter = new RecyclerViewAdapter(employeeList);


    }




    }
