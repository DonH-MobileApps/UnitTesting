package com.example.employeedatabase;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class InputFragment extends Fragment {

    EditText etName, etBirthday, etWage, etHireDate;
    Button btnSndEmployeeData;
    OnEmployeeSetListener onEmployeeSetListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.input_fragment,container,false);
        etName = (EditText)view.findViewById(R.id.etName);
        etBirthday = (EditText)view.findViewById(R.id.etBirthday);
        etWage = (EditText)view.findViewById(R.id.etWage);
        etHireDate = (EditText)view.findViewById(R.id.etHireDate);
        btnSndEmployeeData = (Button) view.findViewById(R.id.btnSendData);

        btnSndEmployeeData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = etName.getText().toString();
                String Birthday = etBirthday.getText().toString();
                String Wage = etWage.getText().toString();
                String HireDate = etHireDate.getText().toString();



            }
        });

        return view;
    }

    public interface OnEmployeeSetListener {
        public void setEmployee(String employee);

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


        onEmployeeSetListener = (OnEmployeeSetListener) context;
    }
}
