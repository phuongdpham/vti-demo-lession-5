package com.example.demolession5.model.solid.liskov;

public class Car extends Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving car");
    }

    public void drift() {
        System.out.println("Drifting car");
    }
}
