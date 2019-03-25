package com.example.dependencyinjection.model.car;

import javax.inject.Inject;

public class Wheels {
    Rims rims;
    Tires tires;

    @Inject
    public Wheels(Rims rims, Tires tires){
        this.rims = rims;
        this.tires = tires;

    }
}
