package com.example.week3day2hw;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class DataEntry extends AppCompatActivity {
    public static final String KEY_STUDENT_RESULT = "student_result";
    public static final int RESULT_CODE = 777;

    EditText etStudentIdDisplay;
    EditText etStudentNameDisplay;
    EditText etStudentMajorDisplay;
    EditText etStudentMinorDisplay;
    EditText etStudentGradYearDisplay;
    EditText etStudentGPADisplay;
    EditText etStudentCompletedYears;
    Intent sentIntent;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_entry);
        sentIntent = getIntent();
        bindViews();
    }

        public void bindViews() {
            etStudentIdDisplay = findViewById(R.id.etStudentId);
            etStudentNameDisplay = findViewById(R.id.etStudentName);
            etStudentMajorDisplay = findViewById(R.id.etStudentMajor);
            etStudentMinorDisplay = findViewById(R.id.etStudentGradYear);
            etStudentGradYearDisplay = findViewById(R.id.etStudentGPA);
            etStudentGPADisplay = findViewById(R.id.etStudentGPA);
            etStudentCompletedYears = findViewById(R.id.etStudentCompletedYears);

        }

        public Student generateStudentObjectFromInput() {
            Student returnStudent = new Student();
        }

        public Student generateStudentObjectFromInput() {

            Student returnStudent = new Student();

            returnStudent.setStudentId(
                    etStudentIdDisplay.getText() != null ? etStudentIdDisplay.getText().toString() : "");
            returnStudent.setStudentName(
                    etStudentNameDisplay.getText() != null ? etStudentNameDisplay.getText().toString() : "");
            returnStudent.setStudentMajor(
                    etStudentMajorDisplay.getText() != null ? etStudentMajorDisplay.getText().toString() : "");
            returnStudent.setStudentMinor(
                    etStudentMinorDisplay.getText() != null ? etStudentMinorDisplay.getText().toString() : "");
            returnStudent.setStudentGradYear(
                    etStudentGradYearDisplay.getText() != null ? etStudentGradYearDisplay.getText().toString() : "");
            returnStudent.setStudentGPA(
                    etStudentGPADisplay.getText() != null ? etStudentGPADisplay.getText().toString() : "");
            returnStudent.setStudentCompletedHrs(
                    etStudentCompletedYears.getText() != null ? etStudentCompletedYears.getText().toString() : "");

            return returnStudent;

        }

        public void onClick(View View) {
        Student studentResult = generateStudentObjectFromInput();
        Bundle bundleOfTheStudentResult = new Bundle();
        bundleOfTheStudentResult.putParcelable(KEY_STUDENT_RESULT, studentResult);
        sentIntent.putExtras(bundleOfTheStudentResult);
        setResult(RESULT_CODE, sentIntent);
        finish();


    }

}
