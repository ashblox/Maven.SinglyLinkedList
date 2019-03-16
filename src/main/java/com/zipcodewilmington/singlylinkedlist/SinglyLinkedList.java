package com.zipcodewilmington.singlylinkedlist;

import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T> {

    private Node<T> head;
    private int size;

    public Iterator<T> iterator() {
        return new CustomIterator<T>(this);
    }

    public class CustomIterator<T> implements Iterator<T> {

        Node<T> current;

        public CustomIterator(SinglyLinkedList<T> singlyLinkedList) {
            this.current = singlyLinkedList.head;
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T t = current.element;
            current = current.next;
            return t;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static class Node<T> {

        private T element;
        private Node<T> next;

        public Node(T element) {
            this.element = element;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", next=" + next +
                    '}';
        }
    }

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void add(T element) {
        Node node = new Node(element);
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
        size++;
    }

    public T remove(int index) {
        T element = null;
        if (size - 1 < index) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            element = removeFirstElement();
        } else {
            element = removeOtherElement(index);
        }
        return element;
    }

    public T removeFirstElement() {
        T element = head.element;
        if (head.next == null) {
            head = null;
        } else {
            head = head.next;
        }
        return element;
    }

    public T removeOtherElement(int index) {
        T element = null;
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        element = (T)temp.next.element;
        temp.next = temp.next.next;
        return element;
    }

    public boolean contains(T t) {
        boolean contains = false;
        for (T element : this) {
            if (element == t) {
                contains = true;
            }
        }
        return contains;
    }

//    public int find(T t) {
//        int index = -1;
//        for (T element : this) {
//            index
//        }
//    }

    public int size() {
        return size;
    }

    public Node<T> getHead() {
        return head;
    }
}
