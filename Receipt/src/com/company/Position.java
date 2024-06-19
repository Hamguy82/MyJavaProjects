package com.company;

public class Position {
    private String name;
    private int amount;
    private int price;

    public Position(String name, int amount, int price) {
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int getTotal() {
        return price * amount;
    }

    @Override
    public String toString() {
        return String.format("Name = %20s , Amount = %3d , Price = %3d", name, amount, price);
    }
}
