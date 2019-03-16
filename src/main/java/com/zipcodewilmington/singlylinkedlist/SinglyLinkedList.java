package com.zipcodewilmington.singlylinkedlist;

public class SinglyLinkedList<T> {

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
            throw new IndexOutOfBoundsException(String.format("List only contains %d elements", size - 1));
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

    public int size() {
        return size;
    }

    public Node<T> getHead() {
        return head;
    }
}
