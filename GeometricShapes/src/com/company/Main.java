package com.company;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Shape> list = List.of(new Rectangle(2,3), new Triangle(1,1,1));
        Rectangle rectangle = new Rectangle(1,4);
        for (Shape shape: list) {
            System.out.println(shape.getName());
            System.out.println(rectangle.equals(shape));
            System.out.println(shape.perimeter());
            System.out.println(shape.square());
        }
    }
}
