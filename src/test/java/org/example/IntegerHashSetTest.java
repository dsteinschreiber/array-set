package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntegerHashSetTest {
    @Test
    public void containsTest() {
        assertTrue(IntegerHashSet.of(1000,
                        50, 10, 3200, 150, 1050, 1000020, 1000010)
                .contains(10));

        assertTrue(IntegerHashSet.of(1000, 1050)
                .contains(1050));
    }

    @Test
    public void isEmptyTest() {
        GenericHashSet<Integer> test = IntegerHashSet.of(1000);

        assertTrue(test.isEmpty());

        test.add(123);

        assertFalse(test.isEmpty());
    }

    @Test
    public void sizeTest() {
        GenericHashSet<Integer> test = IntegerHashSet.of(1000, 10, 20, 30, 40, 50);

        assertEquals(5, test.size());
    }

    @Test
    public void toListTest() {
        GenericHashSet<Integer> test = IntegerHashSet.of(1000,
                10, 20, 30, 40);

        System.out.println(test.toList());
    }

    @Test
    public void equalsTest() {
        GenericHashSet<Integer> test1 = IntegerHashSet.of(1000, 10, 20, 30, 40);
        GenericHashSet<Integer> test2 = IntegerHashSet.of(1000, 40, 20, 10, 30);

        assertEquals(test1, test2);

    }
}
