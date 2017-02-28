package com.kojidev.epamhw.unit1;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class IntArrayList {
    private int[] data;
    private int size;

    public IntArrayList(int[] data) {
        this.data = Arrays.copyOf(data, data.length);
        size = data.length;
    }

    public IntArrayList() {
        data = new int[10];
        size = 0;
    }

    public void add(int value) {
        ensureCapasity(size + 1);
        data[size] = value;
        size += 1;
    }

    public int get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }

        return data[i];
    }

    public int getSize() {
        return size;
    }

    public int maxValueInefficient() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return maxValueRec(data, 0, size);
    }

    private int maxValueRec(int[] data, int startInclusive, int endExlusive) {
        final int length = endExlusive - startInclusive;

        if (length == 1) {
            return data[startInclusive];
        } else if (length == 0) {
            return Integer.MIN_VALUE;
        }

        final int mid = startInclusive + length/2;
        return Math.max(
                maxValueRec(data, startInclusive, mid),
                maxValueRec(data, mid, endExlusive)
        );
    }

    public void sortDown(){
        mergeSort(data, 0, getSize(), new int[getSize()]);
    }

    public void sortUp(){
        mergeSort(data, 0, getSize(), new int[getSize()]);
    }


    /**
     * Expects collection to be sorted.
     *
     * @param value value to find in collection
     *
     * @return index of the value or -indexToInsert - 1
     */
    public int binarySearch(int value) {
        return binarySearch(value,0,data.length - 1);
    }

    /**
     * Recursive method that's seeking for a value
     * by splitting the data array by 2 until last element
     *
     * @param value value which index we are searching for
     * @param startInclusive index from what we start
     * @param endInclusive last index in the range
     * @return index of the value or -indexToInsert - 1
     */
    private int binarySearch(int value, int startInclusive, int endInclusive) {

        final int currentIndex = startInclusive + (endInclusive - startInclusive)/2;
        final int current = data[currentIndex];

        if (endInclusive == startInclusive) {
            return current == value ? currentIndex : startInclusive - 1;
        } else {
            return value <= current ?
                    binarySearch(value, startInclusive, currentIndex) :
                    binarySearch(value, currentIndex + 1, endInclusive);
        }
    }

    private static void mergeSort(int[] data, int startInclusive, int endExclusive, int[] free) {
        final int length = endExclusive - startInclusive;
        if (length <= 1) {
            return;
        }

        final int mid = startInclusive + length/2;

        mergeSort(data, startInclusive, mid, free);
        mergeSort(data, mid, endExclusive, free);

        merger(data, startInclusive, mid, endExclusive, free);
    }

    private static void merger(int[] data, int startInclusive, int mid, int endExclusive, int[] free) {
        System.arraycopy(data, startInclusive, free, startInclusive, endExclusive - startInclusive);

        int i = startInclusive;
        int j = mid;
        for (int k = startInclusive; k < endExclusive; k++) {
            if (i >= mid) data[k] = free[j++];
            else if (j >= endExclusive) data[k] = free[i++];
            else if (free[i] < free[j]) data[k] = free[i++];
            else data[k] = free[j++];
        }
    }

    private void ensureCapasity(int requiredCapacity) {
        if (requiredCapacity <= getCapacity()) {
            return;
        }
        final int newCapasity = Math.max(requiredCapacity, (getCapacity() * 3) / 2 + 1);
        data = Arrays.copyOf(data, newCapasity);
    }

    private int getCapacity() {
        return data.length;
    }


}