package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GenericHashSetTest {
    @Test
    public void containsTest() {
        GenericHashSet<String> test = GenericHashSet.of("hi", "hello");

        assertTrue(test.contains("hi"));
        assertTrue(test.contains("hello"));
    }
}
