package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PureIntegerHashSetTest {

    @Test
    public void containsTest() {
        assertTrue(PureIntegerHashSet.of(1000,
                50, 10, 3200, 150, 1050, 1000020, 1000010)
                .contains(10));

        assertTrue(PureIntegerHashSet.of(1000, 1050)
                .contains(1050));
    }
}
