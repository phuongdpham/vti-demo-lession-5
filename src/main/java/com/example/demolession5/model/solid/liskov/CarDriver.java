package com.example.demolession5.model.solid.liskov;

public class CarDriver {
    public void drives(Car car) {
        car.drive();

        car.drift();
    }

    public static void main(String[] args) {
//        CarDriver carDriver = new CarDriver();
//        carDriver.drives(new Car());

        var garage = new Garage();
        garage.park(new Car());
        garage.park(new Truck());
    }
}
