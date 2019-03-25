package com.example.dependencyinjection.model.car;

import android.util.Log;

import javax.inject.Inject;

public class Engine {

    @Inject
    public Engine(){

    }

    public void startEngine() {
        Log.d("TAG", " startEngine:VROOM");

    }

}
