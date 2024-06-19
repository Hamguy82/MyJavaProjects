package com.company;

public class Car implements MotorTransport, Radio{
    @Override
    public void move() {
        System.out.println("Car moved");
    }

    @Override
    public void refuel() {
        System.out.println("Car refueled");
    }

    @Override
    public void listen() {
        System.out.println("Radio is playing in the car");
    }
}
