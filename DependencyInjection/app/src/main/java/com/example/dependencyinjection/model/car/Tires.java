package com.example.dependencyinjection.model.car;

import android.util.Log;

public class Tires {
    int tirePressure;


    public void infateTires(){
        Log.d("TAG,","inflateTires:Tires now inflated PSI " + tirePressure);

    }

    public void setTirePressure(int tirePressure){
        this.tirePressure = tirePressure;

    }
}
