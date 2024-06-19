package com.company;

public class Main {
    public static void main(String[] args) {
//        Position position1 = new Position("Bread", 2, 1);
//        Position position2 = new Position("Egg", 1, 2);
        Receipt receipt = new Receipt();
        receipt.add("Bread", 2, 1);
        receipt.add("Bread", 2, 1);
        receipt.add("Egg", 1, 2);
        receipt.displayItems();
    }
}
