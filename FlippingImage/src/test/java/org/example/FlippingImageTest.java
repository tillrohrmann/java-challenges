package org.example;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class FlippingImageTest {

    @Test
    public void testFlipAndInvertSimpleImage() {
        final int[][] input = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        final int[][] expected = {{1, 0, 0}, {0, 1, 0}, {1, 1, 1}};

        assertThat(FlippingImage.flipAndInvertImage(input), is(expected));
    }

    @Test
    public void testFlipAndInvertMoreComplexImage() {
        final int[][] input = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        final int[][] expected = {{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}, {1, 0, 1, 0}};

        assertThat(FlippingImage.flipAndInvertImage(input), is(expected));
    }

}