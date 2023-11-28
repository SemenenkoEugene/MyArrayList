package org.example;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    MyArrayList<Integer> list = new MyArrayList<>();

    @Test
    void testAddTwoNumber() {
        list.addElement(1);
        list.addElement(2);
        assertEquals(2, list.size());
    }

    @Test
    void testAddElementIndex1() {
        list.addElement(1);
        list.addElement(2);
        list.addElement(1, 0);
        assertEquals(0, list.get(1));
    }

    @Test
    void testDeleteElement() {
        list.addElement(0);
        list.addElement(2);

        assertEquals(2, list.size());

        list.deleteElement(2);
        assertNull(list.get(1));
    }

    @Test
    void testDeleteElementNotFound() {
        list.addElement(1);
        list.addElement(2);

        assertEquals(2, list.size());
        assertThrows(NoSuchElementException.class, () -> list.deleteElement(3));
    }

    @Test
    void testGet() {
        list.addElement(1);
        list.addElement(2);

        assertEquals(2, list.get(1));
    }

    @Test
    void testGetIndexOut() {
        list.addElement(1);
        list.addElement(2);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(-1));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(11));
    }

    @Test
    void testIsEmpty() {
        assertEquals(0, list.size());
    }

}