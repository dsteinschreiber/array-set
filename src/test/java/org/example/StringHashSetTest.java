package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class StringHashSetTest {

    @Test
    public void containsTest(){
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
        GenericHashSet<String> test = StringHashSet.of(1000,"hello","world","goodnight","moon");

        assertEquals(4, test.size());
    }


}
