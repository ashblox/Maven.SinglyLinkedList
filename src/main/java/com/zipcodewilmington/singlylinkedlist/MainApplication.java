package com.zipcodewilmington.singlylinkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leon on 1/10/18.
 */
public class MainApplication {

    public static void main(String[] args) {
        SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
        String s1 = "this";
        String s2 = "is";
        String s3 = "a";
        String s4 = "test";

        sll.add(s1);
        sll.add(s2);
        sll.add(s3);
        sll.add(s4);

        System.out.println(sll.contains("hi"));

//        System.out.println(sll.getHead());
//        System.out.println(sll.remove(5));
//        System.out.println(sll.getHead());

    }
}
