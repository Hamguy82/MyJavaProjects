package com.company;

import java.util.Objects;

public class Rectangle extends Shape{
    private int side1;
    private int side2;



    public Rectangle(int side1, int side2) {
        super("Rectangle");
        this.side1 = side1;
        this.side2 = side2;
    }


    @Override
    public int perimeter() {
        return side1 * 2 + side2 * 2;
    }

    @Override
    public int square() {
        return side1 * side2;
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Rectangle rectangle = (Rectangle) o;
        return side1 == rectangle.side1 && side2 == rectangle.side2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), side1, side2);
    }
}
