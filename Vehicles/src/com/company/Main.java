package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Transport> list = List.of(new Car(), new Boat(), new Bicycle());
        for (Transport transport : list) {
            if (transport instanceof MotorTransport motorTransport) {
                motorTransport.refuel();
            }
        }
    }
}
