package com.company;

public class MyNode<T> {
    private T data;
    private MyNode<T> previous;
    private MyNode<T> next;

    public MyNode(MyNode<T> previous, T data, MyNode<T> next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public MyNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(MyNode<T> previous) {
        this.previous = previous;
    }

    public MyNode<T> getNext() {
        return next;
    }

    public void setNext(MyNode<T> next) {
        this.next = next;
    }
}
