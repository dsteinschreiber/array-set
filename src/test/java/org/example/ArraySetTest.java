package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArraySetTest {
    @Test
    public void containsTest() {
        assertTrue(ArraySet.of(100, 1, 5, 10, 12, 16, 20, 22)
                .contains(1));

        assertTrue(ArraySet.of(100, 1, 5, 10, 12, 16, 20, 22)
                .contains(5));

        assertTrue(ArraySet.of(100, 1, 5, 10, 12, 16, 20, 22)
                .contains(10));

        assertFalse(ArraySet.of(100, 1, 5, 10, 12, 16, 20, 22)
                .contains(3));

        assertFalse(ArraySet.of(100).contains(1));
    }

}
