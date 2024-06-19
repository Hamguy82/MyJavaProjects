package com.company;

public class Dog extends Animal{

    public Dog() {
        super("Balloon");
    }

    @Override
    public void makeSound() {
        System.out.println("Gauw");
    }
}
