package com.company;

import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyLinkedList<T> implements Iterable<T>{
    private MyNode<T> firstNode = null;
    private MyNode<T> lastNode = null;
    private int counter = 0;


    public void add(T data) {
        MyNode<T> myNode = new MyNode<>(lastNode, data, null);
        if (firstNode == null) {
            firstNode = myNode;
        } else {
            lastNode.setNext(myNode);
        }
        lastNode = myNode;
        counter++;
    }

    public void add(int index, T data) {
        indexCheckerBoundsIncluded(index);
        MyNode<T> node = findNode(index);
        MyNode<T> previousNode = node == null ? lastNode : node.getPrevious();
        MyNode<T> myNode = new MyNode<>(previousNode, data, node);

        if (previousNode == null) {
            firstNode = myNode;
        } else {
            previousNode.setNext(myNode);
        }
        if (node == null) {
            lastNode = myNode;
        } else {
            node.setPrevious(myNode);
        }

        counter++;
    }

    public T get(int index) {
        indexChecker(index);
        return findNode(index).getData();
    }

    private void indexChecker(int index) {
        if (index < 0 || index >= counter) {
            throw new IllegalArgumentException("Incorrect Index %d out of size %d ".formatted(index, counter));
        }
    }

    private void indexCheckerBoundsIncluded(int index) {
        if (index < 0 || index > counter) {
            throw new IllegalArgumentException("Incorrect Index %d out of size %d ".formatted(index, counter));
        }
    }

    private MyNode<T> findNode(int index) {
        if (index == counter) {
            return null;
        }
        MyNode<T> myNode;
        if (index < counter / 2) {
            myNode = firstNode;
            for (int i = 0; i < index; i++) {
                myNode = myNode.getNext();
            }
        } else {
            myNode = lastNode;
            for (int i = counter - 1; i > index; i--) {
                myNode = myNode.getPrevious();
            }
        }
        return myNode;
    }

    public int size() {
        return counter;
    }

    public T remove(int index) {
        indexChecker(index);
        MyNode<T> node = findNode(index);
        nodeDeletion(node);
        return node.getData();
    }

    private void nodeDeletion(MyNode<T> node) {
        MyNode<T> previousNode = node.getPrevious();
        MyNode<T> nextNode = node.getNext();
        if (previousNode == null) {
            firstNode = nextNode;
        } else {
            previousNode.setNext(nextNode);
        }
        if (nextNode == null) {
            lastNode = previousNode;
        } else {
            nextNode.setPrevious(previousNode);
        }
        counter--;
    }

    public boolean remove(T data) {
        MyNode<T> node = findNode(data);
        if (node == null) {
            return false;
        }
        nodeDeletion(node);
        return true;
    }

    private MyNode<T> findNode(T data) {
        MyNode<T> myNode = firstNode;
        for (int i = 0; i < counter; i++) {
            if (myNode.getData().equals(data)) {
                return myNode;
            }
            myNode = myNode.getNext();
        }
        return null;
    }

    public void addToBeginning(MyLinkedList<T> otherLinkedList) {
        otherLinkedList.lastNode.setNext(firstNode);
        firstNode.setPrevious(otherLinkedList.lastNode);
        firstNode = otherLinkedList.firstNode;
        counter += otherLinkedList.counter;
    }

    public void addToEnd(MyLinkedList<T> otherLinkedList) {
        lastNode.setNext(otherLinkedList.firstNode);
        otherLinkedList.firstNode.setPrevious(lastNode);
        lastNode = otherLinkedList.lastNode;
        counter += otherLinkedList.counter;
    }

    public void clear() {
        firstNode = null;
        lastNode = null;
        counter = 0;
    }

    //        if (node == firstNode) {
//            firstNode = nextNode;
//            if (firstNode != null) {
//                firstNode.setPrevious(null);
//            } else {
//                lastNode = null;
//            }
//        } else if (node == lastNode) {
//            lastNode = previousNode;
//            if (lastNode != null) {
//                lastNode.setNext(null);
//            }
//        } else {
//            previousNode.setNext(nextNode);
//            nextNode.setPrevious(previousNode);
//        }


    @Override
    public String toString() {
        return Stream.iterate(firstNode, Objects::nonNull, MyNode::getNext)
                .map(MyNode::getData)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));

//        StringBuilder sb = new StringBuilder();
//        MyNode<T> myNode = firstNode;
//        for (int i = 0; i < counter - 1; i++) {
//            sb.append(myNode.getData()).append(", ");
//            myNode = myNode.getNext();
//        }
//        if (lastNode != null) {
//            sb.append(myNode.getData());
//        }
//        return "[" + sb + "]";c
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    public Stream<T> stream() {
        return Stream.iterate(firstNode, Objects::nonNull, MyNode::getNext)
                .map(MyNode::getData);
    }

    private class MyIterator implements Iterator<T> {
        private MyNode<T> currentNode = firstNode;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public T next() {
            T data = currentNode.getData();
            currentNode = currentNode.getNext();
            return data;
        }
    }
}
