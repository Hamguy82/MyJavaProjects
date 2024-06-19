package com.company;

public class Main {
    public static void main(String[] args) {
        MyList<String> myList = new MyList<>();

        myList.add("Hello");
        myList.add("Hel");
        myList.add("Helo");
        myList.add("He");
        myList.add("Java");
        myList.add("Jav");
        myList.add("Jaa");
        myList.add("Jva");
        myList.add("ava");
        myList.add("Jva");
        myList.add("Java");
        myList.add("va");
        System.out.println(myList);
        myList.remove(20);
        myList.add("!!!!", 2);
        System.out.println(myList.size());
        System.out.println(myList);
    }
}
