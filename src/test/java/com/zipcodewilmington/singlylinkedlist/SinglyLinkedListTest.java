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

    @Test
    public void removeFirstElementTest() {
        // Given
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();
        Integer firstValue = 72;
        singlyLinkedList.add(firstValue);
        singlyLinkedList.add(56);
        singlyLinkedList.add(23);
        String expected = "SinglyLinkedList{head=Node{element=56, next=Node{element=23, next=null}}, size=2}";

        // When
        singlyLinkedList.removeFirstElement();
        String actual = singlyLinkedList.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeOtherElementTest1() {
        // Given
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<String>();
        int index = 2;
        singlyLinkedList.add("piggies");
        singlyLinkedList.add("in");
        singlyLinkedList.add("the");
        singlyLinkedList.add("street");
        String expected = "SinglyLinkedList{head=Node{element=piggies, next=Node{element=in, next=Node{element=street, next=null}}}, size=3}";

        // When
        singlyLinkedList.removeOtherElement(index);
        String actual = singlyLinkedList.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeOtherElementTest2_LastElement() {
        // Given
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<String>();
        int index = 3;
        singlyLinkedList.add("piggies");
        singlyLinkedList.add("in");
        singlyLinkedList.add("the");
        singlyLinkedList.add("street");
        String expected = "SinglyLinkedList{head=Node{element=piggies, next=Node{element=in, next=Node{element=the, next=null}}}, size=3}";

        // When
        singlyLinkedList.removeOtherElement(index);
        String actual = singlyLinkedList.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void containsTest1() {
        // Given
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();
        Integer valueToFind = 5;
        singlyLinkedList.add(3);
        singlyLinkedList.add(valueToFind);
        singlyLinkedList.add(4);

        // When/Then
        Assert.assertTrue(singlyLinkedList.contains(valueToFind));
    }

    @Test
    public void containsTest2() {
        // Given
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<String>();
        String wordToFind = "banana";
        singlyLinkedList.add("apples");
        singlyLinkedList.add("are");
        singlyLinkedList.add("great");

        // When/Then
        Assert.assertFalse(singlyLinkedList.contains(wordToFind));
    }

    @Test
    public void findElementTest1() {
        // Given
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();
        int expected = 2;
        Integer valueToFind = 6;
        singlyLinkedList.add(3);
        singlyLinkedList.add(4);
        singlyLinkedList.add(valueToFind);
        singlyLinkedList.add(7);

        // When
        int actual = singlyLinkedList.find(valueToFind);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findElementTest2() {
        // Given
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();
        int expected = -1;
        Integer valueToFind = 348;
        singlyLinkedList.add(3);
        singlyLinkedList.add(4);
        singlyLinkedList.add(7);

        // When
        int actual = singlyLinkedList.find(valueToFind);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findElementTest3() {
        // Given
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<String>();
        int expected = 3;
        String wordToFind = "test";
        singlyLinkedList.add("this");
        singlyLinkedList.add("is");
        singlyLinkedList.add("a");
        singlyLinkedList.add(wordToFind);

        // When
        int actual = singlyLinkedList.find(wordToFind);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sizeTest() {
        // Given
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();
        singlyLinkedList.add(3);
        singlyLinkedList.add(2);
        singlyLinkedList.add(12);
        singlyLinkedList.remove(1);
        singlyLinkedList.remove(1);
        singlyLinkedList.add(3);
        int expected = 2;

        // When
        int actual = singlyLinkedList.size();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTest1() {
        // Given
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<String>();
        String expected = "Ghettysburg";
        singlyLinkedList.add("Washington");
        singlyLinkedList.add(expected);
        singlyLinkedList.add("Wilmington");

        // When
        String actual = singlyLinkedList.get(1);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTest2() {
        // Given
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();
        Integer expected = 23;
        singlyLinkedList.add(expected);
        singlyLinkedList.add(2);

        // When
        Integer actual = singlyLinkedList.get(0);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getTest3() {
        // Given
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();
        Integer expected = 312;
        singlyLinkedList.add(238);
        singlyLinkedList.add(276);
        singlyLinkedList.add(expected);

        // When
        Integer actual = singlyLinkedList.get(2);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest() {
        // Given
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<String>();
        singlyLinkedList.add("molly");
        singlyLinkedList.add("the");
        singlyLinkedList.add("tiger");
        String expected = "SinglyLinkedList{head=Node{element=molly, next=Node{element=the, next=Node{element=tiger, next=null}}}, size=3}";

        // When
        String actual = singlyLinkedList.toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void copyTest() {
        // Given
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<String>();
        singlyLinkedList.add("howdy");
        singlyLinkedList.add("my");
        singlyLinkedList.add("name");
        String expected = "SinglyLinkedList{head=Node{element=howdy, next=Node{element=my, next=Node{element=name, next=null}}}, size=3}";

        SinglyLinkedList<String> copiedList = singlyLinkedList.copy();
        singlyLinkedList.remove(2);
        singlyLinkedList.add("age");
        String actual = copiedList.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortTest1() {
        // Given
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<Integer>();
        singlyLinkedList.add(13);
        singlyLinkedList.add(2);
        singlyLinkedList.add(6);
        singlyLinkedList.add(0);
        String expected = "SinglyLinkedList{head=Node{element=0, next=Node{element=2, next=Node{element=6, next=Node{element=13, next=null}}}}, size=4}";

        // When
        String actual = singlyLinkedList.sort().toString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sortTest2() {
        SinglyLinkedList<String> singlyLinkedList = new SinglyLinkedList<String>();
        singlyLinkedList.add("this");
        singlyLinkedList.add("is");
        singlyLinkedList.add("a");
        singlyLinkedList.add("test");
        String expected = "SinglyLinkedList{head=Node{element=a, next=Node{element=is, next=Node{element=test, next=Node{element=this, next=null}}}}, size=4}";

        String actual = singlyLinkedList.sort().toString();

        Assert.assertEquals(expected, actual);
    }
}
