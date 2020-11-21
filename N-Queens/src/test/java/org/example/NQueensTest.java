package org.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class NQueensTest {

    @Test
    public void testNQueensSimple() {
        assertThat(NQueens.solveNQueens(1), is(Collections.singletonList(Collections.singletonList("Q"))));
    }

    @Test
    public void testNQueens4() {
        final List<String> solutionA = Arrays.asList(".Q..", "...Q", "Q...", "..Q.");
        final List<String> solutionB = Arrays.asList("..Q.", "Q...", "...Q", ".Q..");
        final List<List<String>> expectedSolution = Arrays.asList(solutionA, solutionB);
        assertThat(NQueens.solveNQueens(4), containsInAnyOrder(solutionA, solutionB));
    }

}