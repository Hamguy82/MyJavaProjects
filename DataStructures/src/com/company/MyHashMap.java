package com.company;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyHashMap<K, V> {
    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private MyLinkedList<MyEntry<K, V>>[] table = new MyLinkedList[INITIAL_CAPACITY];
    private int counter = 0;

    public V put(K key, V value) {
        if (counter >= table.length * LOAD_FACTOR) {
            increaseSize();
        }
        MyEntry<K, V> entry = getEntry(key);
        if (entry != null) {
            V previousValue = entry.getValue();
            entry.setValue(value);
            return previousValue;
        }
        int basketId = getBasketId(key);
        if (table[basketId] == null) {
            table[basketId] = new MyLinkedList<>();
        }
        table[basketId].add(new MyEntry<>(key, value));
        counter++;
        return null;
    }

    private void increaseSize() {
        counter = 0;
        MyLinkedList<MyEntry<K, V>>[] oldTable = table;
        table = new MyLinkedList[table.length * 2];
        for (MyLinkedList<MyEntry<K, V>> list : oldTable) {
            if (list == null) {
                continue;
            }
            for (MyEntry<K, V> myEntry : list) {
                put(myEntry.getKey(), myEntry.getValue());
            }
        }
    }


    private MyEntry<K, V> getEntry(K key) {
        MyLinkedList<MyEntry<K, V>> basket = table[getBasketId(key)];
        if (basket == null) {
            return null;
        }
        int hashCode = key.hashCode();
        for (MyEntry<K, V> myEntry : basket) {
            if (myEntry.getHash() == hashCode && myEntry.getKey().equals(key)) {
                return myEntry;
            }
        }
        return null;
    }

    public V get(K key) {
        MyEntry<K, V> entry = getEntry(key);
        return entry == null ? null : entry.getValue();
    }

    public int size() {
        return counter;
    }

    private int getBasketId(K key) {
        return Math.floorMod(key.hashCode(), table.length);
    }

    public boolean removeKey(K key) {
        MyEntry<K, V> entry = getEntry(key);
        if (entry == null) {
            return false;
        }
        MyLinkedList<MyEntry<K, V>> list = table[getBasketId(key)];
        list.remove(entry);
        counter--;
        return true;
    }

    @Override
    public String toString() {
        return Arrays.stream(table)
                .filter(Objects::nonNull)
                .flatMap(MyLinkedList::stream)
                .map(MyEntry::toString)
                .collect(Collectors.joining(", ", "{", "}"));
//        StringBuilder stringBuilder = new StringBuilder();
//        for (MyLinkedList<MyEntry<K, V>> list : table) {
//            if (list == null) {
//                continue;
//            }
//            for (MyEntry<K, V> myEntry : list) {
//                if (!stringBuilder.isEmpty()) {
//                    stringBuilder.append(", ");
//                }
//                stringBuilder.append(myEntry.getKey()).append("=").append(myEntry.getValue());
//            }
//        }
//        return "{" + stringBuilder + "}";

    }
}
