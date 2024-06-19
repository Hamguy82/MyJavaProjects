package com.company;

import java.util.Objects;

public abstract class Shape {
    private String name;
    public abstract int perimeter();
    public abstract int square();

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shape shape = (Shape) o;
        return Objects.equals(name, shape.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
