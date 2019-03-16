package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListTest {

    @Test
    public void addElementTest1() {
        // Given
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<String>();
        String expected = "donut";

        // When
        singlyLinkedList.add(expected);
        String actual = singlyLinkedList.remove(0);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addElementTest2() {
        // Given
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<String>();
        String first = "donut";
        String expected = "pie";
        singlyLinkedList.add(first);

        // When
        singlyLinkedList.add(expected);
        String actual = singlyLinkedList.remove(1);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addElementTest3() {
        // Given
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<String>();
        String expected = "donut";
        String second = "pie";

        // When
        singlyLinkedList.add(expected);
        singlyLinkedList.add(second);
        String actual = singlyLinkedList.remove(0);

        // Then
        Assert.assertEquals(expected, actual);
    }
}
