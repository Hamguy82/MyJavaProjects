package com.company;

public class Recursion {
    public void start() {
//        printer(5);
    }

    public void printer(int count) {
        if (count <= 0) {
            return;
        }
        System.out.println("Hello");
        printer(count - 1);
    }

    private int fact(int number) {
        if (number != 0) {
            return number * fact(number - 1);
        }
        return 1;
    }

    private int fib(int number) {
        if (number <= 1) {
            return number;
        }
        return fib(number - 1) + fib(number - 2);
    }
}
