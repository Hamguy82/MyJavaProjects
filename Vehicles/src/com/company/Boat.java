package com.company;

public class Boat implements MotorTransport{
    @Override
    public void refuel() {
        System.out.println("Boat refueled");
    }

    @Override
    public void move() {
        System.out.println("Boat moved");
    }
}
