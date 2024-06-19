package com.company;

public class MyEntry<K, V> {
    private K key;
    private V value;
    private final int hash;

    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
        hash = key.hashCode();
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public int getHash() {
        return hash;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }

}
