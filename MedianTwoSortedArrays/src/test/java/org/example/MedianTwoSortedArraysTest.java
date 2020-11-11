package org.example;


import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MedianTwoSortedArraysTest {

    @Test
    public void testMedianFirstCase() {
        assertThat(MedianTwoSortedArrays.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), is(2.0));
    }

    @Test
    public void testMedianSecondCase() {
        assertThat(MedianTwoSortedArrays.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), is(2.5));
    }

    @Test
    public void testMedianThirdCase() {
        assertThat(MedianTwoSortedArrays.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}), is(0.0));
    }

    @Test
    public void testMedianFourthCase() {
        assertThat(MedianTwoSortedArrays.findMedianSortedArrays(new int[]{}, new int[]{1}), is(1.0));
    }

    @Test
    public void testMedianFifthCase() {
        assertThat(MedianTwoSortedArrays.findMedianSortedArrays(new int[]{2}, new int[]{}), is(2.0));
    }

    @Test
    public void testMedianSixthCase() {
        assertThat(MedianTwoSortedArrays.findMedianSortedArrays(new int[]{1, 4, 5, 10}, new int[]{2, 3, 4, 7, 11, 12}), is(4.5));
    }

    @Test
    public void testMedianSeventhCase() {
        assertThat(MedianTwoSortedArrays.findMedianSortedArrays(new int[]{1, 5, 6, 7}, new int[]{2, 3, 4, 8, 9, 10}), is(5.5));
    }
}