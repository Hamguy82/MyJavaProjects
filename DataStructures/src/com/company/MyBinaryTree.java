package com.company;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyBinaryTree<V extends Comparable<V>> {
    private TreeNode<V> rootNode;
    private int counter;


    public void add(V data) {
        TreeNode<V> currentNode = rootNode;
        TreeNode<V> newNode = new TreeNode<>(data);
        if (rootNode == null) {
            rootNode = newNode;
            counter++;
            return;
        }
        while (true) {
            int result = newNode.getData().compareTo(currentNode.getData());
            if (result > 0) {
                if (currentNode.getRightChild() == null) {
                    currentNode.setRightChild(newNode);
                    break;
                }
                currentNode = currentNode.getRightChild();
            } else if (result < 0) {
                if (currentNode.getLeftChild() == null) {
                    currentNode.setLeftChild(newNode);
                    break;
                }
                currentNode = currentNode.getLeftChild();
            }
        }
        counter++;
    }

    public int size() {
        return counter;
    }

    public boolean contains(V data) {
        TreeNode<V> currentNode = rootNode;
        while (true) {
            if (currentNode == null) {
                return false;
            }
            int result = data.compareTo(currentNode.getData());
            if (result == 0) {
                return true;
            }
            if (result > 0) {
                currentNode = currentNode.getRightChild();
            } else {
                currentNode = currentNode.getLeftChild();
            }
        }
    }

    public boolean recursiveContains(V data) {
        return recursiveContain(data, rootNode);
    }

    private boolean recursiveContain(V data, TreeNode<V> currentNode) {
        if (currentNode == null) {
            return false;
        }
        int result = data.compareTo(currentNode.getData());
        if (result == 0) {
            return true;
        }
        if (result > 0) {
            return recursiveContain(data, currentNode.getRightChild());
        } else {
            return recursiveContain(data, currentNode.getLeftChild());
        }
    }

    public void bfs() {
        Queue<TreeNode<V>> queue = new LinkedList<>();
        queue.add(rootNode);
        while (!queue.isEmpty()) {
            TreeNode<V> currentNode = queue.poll();
            if (currentNode == null) {
                continue;
            }
            System.out.println(currentNode.getData());
            queue.add(currentNode.getLeftChild());
            queue.add(currentNode.getRightChild());
        }
    }

    public void dfs() {
        Stack<TreeNode<V>> stack = new Stack<>();
        stack.add(rootNode);
        while (!stack.isEmpty()) {
            TreeNode<V> currentNode = stack.pop();
            if (currentNode == null) {
                continue;
            }
            System.out.println(currentNode.getData());
            stack.add(currentNode.getRightChild());
            stack.add(currentNode.getLeftChild());
        }
    }

    public void dfsRecursion() {
        dfsRecursive(rootNode);
    }

    private void dfsRecursive(TreeNode<V> currentNode) {
        if (currentNode == null) {
            return;
        }

        System.out.println(currentNode.getData());
        dfsRecursive(currentNode.getLeftChild());
        dfsRecursive(currentNode.getRightChild());
    }

}
