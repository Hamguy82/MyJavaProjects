package com.company;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Position> positions = new ArrayList<>();

    public void add(String name, int amount, int price) {
        positions.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .ifPresentOrElse(
                        p -> p.setAmount(p.getAmount() + amount),
                        () -> positions.add(new Position(name, amount, price))
                );

    }

    private int totalPrice() {
        return positions.stream()
                .mapToInt(Position::getTotal)
                .sum();
    }

    public void displayItems() {
        positions.forEach(System.out::println);
        System.out.println("Total: " + totalPrice());
    }


}
