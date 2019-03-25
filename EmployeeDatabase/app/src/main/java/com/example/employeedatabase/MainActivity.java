package com.example.employeedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    EmployeeDatabaseHelper MyDBHelper;

    public MainActivity(EmployeeDatabaseHelper myDBHelper) {
        MyDBHelper = myDBHelper;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openDB();
    }

    private void openDB() {
    }
}
