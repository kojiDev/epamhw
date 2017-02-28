package com.kojidev.epamhw.unit1;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * @author Simon Popugaev
 * @author Stan
 */
public class IntArrayListTest {
    @Test
    public void sort() throws Exception {
        final int[] ints = {12, 0, -13, 666, 2, 56, 56, 56, 120, -1, 1, 0, Integer.MAX_VALUE, Integer.MIN_VALUE};
        final int[] expected = Arrays.copyOf(ints, ints.length);
        Arrays.sort(expected);

        final IntArrayList list = new IntArrayList(ints);

        list.sortDown();

        for (int i = 0; i < expected.length; i++) {
            assertEquals("i = " + i, expected[i], list.get(i));
        }
    }

    @Test
    public void binarySearch() {

        final int[] ints = {Integer.MIN_VALUE, 1, 4, 5, 7, 1144, 4666, 100511, 999999, Integer.MAX_VALUE};
        final IntArrayList list = new IntArrayList(ints);

        assertTrue(list.binarySearch(1) == 1);
        assertTrue(list.binarySearch(Integer.MIN_VALUE) == 0);
        assertTrue(list.binarySearch(Integer.MAX_VALUE) == 9);
        assertTrue(list.binarySearch(7) == 4);


    }

}