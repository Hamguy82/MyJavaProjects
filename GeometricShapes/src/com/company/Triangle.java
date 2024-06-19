package com.company;

import java.util.Objects;

public class Triangle extends Shape{
    private int side1;
    private int side2;
    private int side3;

    public Triangle(int side1, int side2, int side3) {
        super("Triangle");
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public int perimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public int square() {
        return (int) (side1 * Math.sqrt(3)/4);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Triangle triangle = (Triangle) o;
        return side1 == triangle.side1 && side2 == triangle.side2 && side3 == triangle.side3;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), side1, side2, side3);
    }
}
