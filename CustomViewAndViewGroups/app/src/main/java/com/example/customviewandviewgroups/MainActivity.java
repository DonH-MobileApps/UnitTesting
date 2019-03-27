package com.example.customviewandviewgroups;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Circle circle;
    CompoundView compoundView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        circle = findViewById(R.id.circle);
        compoundView = findViewById(R.id.cmpCompoundView);

        compoundView.setCounterOne(33);
        compoundView.setCounterTwo(13);
        compoundView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        compoundView.setCounterOne(0);
        compoundView.setCounterTwo(0);



    }
}
