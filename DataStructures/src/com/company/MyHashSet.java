package com.company;

public class MyHashSet<V> {
    private static final Object PRESENT = new Object();

    private MyHashMap<V, Object> mySet = new MyHashMap<>();

    public boolean add(V data) {
        return mySet.put(data, PRESENT) == null;
    }

    public boolean contains(V data) {
        return mySet.get(data) != null;
    }

    public int size() {
        return mySet.size();
    }
}
