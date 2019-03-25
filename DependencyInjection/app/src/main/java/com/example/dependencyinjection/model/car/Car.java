package com.example.dependencyinjection.model.car;

import javax.inject.Inject;

public class Car {
    Engine engine;
    Wheels wheels;


    @Inject
    public  Car(Engine engine, Wheels wheels){
      this.engine = engine;
      this.wheels = wheels;

    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Wheels getWheels() {
        return wheels;
    }

    public void setWheels(Wheels wheels) {
        this.wheels = wheels;
    }
}
