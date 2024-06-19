package com.company;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyList<T> {
    private static final double LOAD_FACTOR = 0.75;
    private static final int INITIAL_CAPACITY = 10;
    private T[] array = (T[]) new Object[INITIAL_CAPACITY];
    private int id = 0;

    public void add(T data) {
        add(data, id);
    }

    public void add(T data, int index) {
        if (index > id || index < 0) {
            throw new RuntimeException("Index %d is out of bounds for length %d".formatted(index, id));
        }
        checker();
        for (int i = id; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = data;
        id++;
    }

    private void checker() {
        if (id >= array.length * LOAD_FACTOR) {
            T[] newArray = (T[]) new Object[array.length * 3 / 2 + 1];
            for (int i = 0; i < id; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    public int size() {
        return id;
    }

    public void remove(int index) {
        boundsChecker(index);
        for (int i = index; i < id - 1; i++) {
            array[i] = array[i + 1];
        }
        id--;
    }

    public void clear() {
        array = (T[]) new Object[INITIAL_CAPACITY];
        id = 0;
    }

    public T get(int index) {
        boundsChecker(index);
        return array[index];
    }

    private void boundsChecker(int index) {
        if (index >= id || index < 0) {
            throw new RuntimeException("Index %d is out of bounds for length %d".formatted(index, id));
        }
    }

    @Override
    public String toString() {
        return Arrays.stream(array)
                .limit(id)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
//        STRINGBUILDER METHOD
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < id - 1; i++) {
//            sb.append(array[i]).append(", ");
//        }
//        if (id > 0) {
//            sb.append(array[id - 1]);
//        }
//        return "[" + sb + "]";
    }
}
