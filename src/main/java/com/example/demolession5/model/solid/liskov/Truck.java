package com.example.demolession5.model.solid.liskov;

public class Truck extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving truck");
    }
}
