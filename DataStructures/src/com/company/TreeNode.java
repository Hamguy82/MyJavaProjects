package com.company;

public class TreeNode<V> {
    private V data;
    private TreeNode<V> leftChild = null;
    private TreeNode<V> rightChild = null;

    public TreeNode(V data) {
        this.data = data;
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public TreeNode<V> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode<V> leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode<V> getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode<V> rightChild) {
        this.rightChild = rightChild;
    }
}
