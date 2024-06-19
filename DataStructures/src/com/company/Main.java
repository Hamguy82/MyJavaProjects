package com.company;

public class Main {
    public static void main(String[] args) {
        MyBinaryTree<Integer> myBinaryTree = new MyBinaryTree<>();
        myBinaryTree.add(5);
        myBinaryTree.add(2);
        myBinaryTree.add(1);
        myBinaryTree.add(6);
        myBinaryTree.add(8);
        myBinaryTree.sum();
        System.out.println(myBinaryTree.size());
        System.out.println(myBinaryTree.recursiveContains(8));
        myBinaryTree.dfs();
    }
}
