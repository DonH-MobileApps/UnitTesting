package com.example.myanimalapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {
    Intent passedIntent;
    Animal animal;
    ListView listPassedAnimalNames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        listPassedAnimalNames = findViewById(R.id.listSimpleListView);
        ArrayList<String>arrayAdapter
                = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1);

    }
}
