package com.example.employeedatabase;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {

    ArrayList<Employee> employeeArrayList;

    public MyRecyclerViewAdapter(ArrayList<Employee> employeeArrayList) {
        this.employeeArrayList = employeeArrayList;

    }

    @NonNull
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
        .inflate(R.layout.employee_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerViewAdapter.ViewHolder viewHolder,final int position) {
        Employee currentEmpToPop = employeeArrayList.get(position);

        viewHolder.tvEmpName.setText(currentEmpToPop.getEmployeeName());
        viewHolder.tvEmpBirthday.setText(currentEmpToPop.getEmployeeBirthday());
        viewHolder.tvEmpWage.setText(currentEmpToPop.getEmployeeWage());
        viewHolder.tvEmpHireDate.setText(currentEmpToPop.getEmployeeHireDate());
        viewHolder.ivEmpImage.setImageDrawable(U);

    }

    @Override
    public int getItemCount() {

        return employeeArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvEmpName, tvEmpBirthday, tvEmpWage, tvEmpHireDate;
        ImageView ivEmpImage;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvEmpName = itemView.findViewById(R.id.tvEmpName);
            tvEmpBirthday = itemView.findViewById(R.id.tvEmpBirthday);
            tvEmpWage = itemView.findViewById(R.id.tvEmpWage);
            tvEmpHireDate = itemView.findViewById(R.id.etHireDate);
            ivEmpImage = itemView.findViewById(R.id.ivEmpImage);
        }
    }
}
