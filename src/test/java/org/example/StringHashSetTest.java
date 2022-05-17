package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StringHashSetTest {

    @Test
    public void containsTest() {
        GenericHashSet<String> test = StringHashSet.of(1000, "hello", "world");

        assertTrue(test.contains("hello"));
        assertTrue(test.contains("world"));
        assertFalse(test.contains("peepee"));

    }

    @Test
    public void isEmptyTest() {
        GenericHashSet<String> test = StringHashSet.of(1000);

        assertTrue(test.isEmpty());

        test.add("sup");

        assertFalse(test.isEmpty());
    }

    @Test
    public void sizeTest() {
        GenericHashSet<String> test = StringHashSet.of(1000, "hello", "world", "goodnight", "moon");

        assertEquals(4, test.size());
    }

    @Test
    public void toListTest() {
        GenericHashSet<String> test = StringHashSet.of(1000,
                "hello", "world", "goodnight", "moon");

        System.out.println(test.toList());

    }

    @Test
    public void equalsTest() {
        MySet<String> test1 = StringHashSet
                .of(1000, "hello", "world", "goodnight", "moon");
        MySet<String> test2 = StringHashSet
                .of(1000, "hello", "world", "goodnight", "moon");

        assertEquals(test1, test2);

        MySet<String> test3 = MyListSet.of("world", "hello", "moon", "goodnight");

        assertEquals(test1, test3);
    }

    @Test
    public void someTest() {
        GenericHashSet<String> test = StringHashSet.of(1000, "hello", "hello");

        System.out.println(test);
    }


}
