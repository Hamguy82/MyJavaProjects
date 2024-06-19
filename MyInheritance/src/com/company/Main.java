package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = List.of(new Cat("Sharik"), new Dog());
        animals.forEach(Animal::makeSound);
        animals.forEach(a -> System.out.println(a.getName()));
        Animal tiger = new Animal("Tiger") {
            @Override
            public void makeSound() {
                System.out.println("Arrr");
            }
        };
        Cat cat1 = new Cat("E");
        Cat cat2 = new Cat("E");
        System.out.println(cat2.equals(cat1));
        Cat cat = new Cat("Barsik");
        List<Animal> animals1 = new ArrayList<>();
        animals1.add(new Cat("Mur"));
        animals1.add(new Dog());
        animals1.add(null);
        animals1.add(new Cat("Barsik"));
        String s = "Hello";
        System.out.println("Java".equals(s));
        for (int i = 0; i < animals1.size(); i++) {

            if (cat.equals(animals1.get(i))) {
                System.out.println("Exist");
            }
        }
//        tiger.makeSound();
//
//        System.out.println(tiger);
    }
}
