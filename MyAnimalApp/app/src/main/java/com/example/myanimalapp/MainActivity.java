package com.example.myanimalapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter myAdapter;

    EditText etType;
    EditText etName;
    EditText etSound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etType = findViewById(R.id.etType);
        etName = findViewById(R.id.etName);
        etSound = findViewById(R.id.etSound);

        recyclerView = findViewById(R.id.rvRecyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MyAdapter = new MyAdapter(genetateListOfBeverages());
        recyclerView.setAdapter(myRecyclerViewAdapter);
    }
}
