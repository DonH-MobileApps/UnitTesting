package com.example.dependencyinjection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dependencyinjection.dagger.components.Components;
import com.example.dependencyinjection.dagger.components.DaggerComponents;
import com.example.dependencyinjection.model.car.Car;

public class MainActivity extends AppCompatActivity {
    private Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Components components = DaggerComponents.create();
        components.inject(this);

       // car = components.getCar();
      //  car = getEngine().startEngine();
    }
}
