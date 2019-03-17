package com.zipcodewilmington.singlylinkedlist;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T extends Comparable> {

    private Node<T> head;
    private int size;

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
            Node<T> temp = head;
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
            throw new NoSuchElementException();
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
        size--;
        return element;
    }

    public T removeOtherElement(int index) {
        T element = null;
        Node<T> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        element = (T) temp.next.element;
        temp.next = temp.next.next;
        size--;
        return element;
    }

    public boolean contains(T t) {
        boolean contains = false;
        if (size > 0) {
            Node<T> temp = head;
            if (head.element == t) {
                contains = true;
            }
            while (temp.next != null) {
                temp = temp.next;
                if (temp.element == t) {
                    contains = true;
                }
            }
        }
        return contains;
    }

    public int find(T t) {
        int index = -1;
        if (contains(t)) {
            if (head.element == t) {
                index = 0;
            } else {
                Node<T> temp = head;
                for (int i = 1; temp.next != null; i++) {
                    temp = temp.next;
                    if (temp.element == t) {
                        index = i;
                        break;
                    }
                }
            }
        }
        return index;
    }

    public T get(int index) {
        T t = null;
        if (index > size - 1) {
            throw new NoSuchElementException();
        } else if (index == 0) {
            t = head.element;
        } else if (index > 0) {
            Node<T> temp = head;
            for (int i = 1; temp.next != null; i++) {
                temp = temp.next;
                if (i == index) {
                    t = temp.element;
                    break;
                }
            }
        }
        return t;
    }

    public SinglyLinkedList<T> copy() {
        SinglyLinkedList<T> clone = new SinglyLinkedList<T>();
        for (int i = 0; i < size; i++) {
            clone.add(this.get(i));
        }
        return clone;
    }

    public SinglyLinkedList<T> sort() {
        SinglyLinkedList<T> sorted = new SinglyLinkedList<T>();
        SinglyLinkedList<T> copy = copy();
        while (copy.size > 1) {
            Integer min = copy.findIndexOfMinimum();
            T minimum = copy.get(min);
            copy.remove(min);
            sorted.add(minimum);
        }
        sorted.add(copy.get(0));
        return sorted;
    }

    public int findIndexOfMinimum() {
        Integer min = null;
        for (int i = 0; i < size; i++) {
            int count = 0;
            for (int j = 0; j < size; j++) {
                if (get(i).compareTo(get(j)) < 0) {
                    count++;
                    if (count == size - 1) {
                        min = i;
                        break;
                    }
                }
            }
        }
        return min;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "SinglyLinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }
}
