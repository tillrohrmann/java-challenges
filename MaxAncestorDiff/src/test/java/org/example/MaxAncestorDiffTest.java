package org.example;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MaxAncestorDiffTest {

    @Test
    public void testMaxAncestorDiffSimpleCase() {
        final TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(0, new TreeNode(3), null)));

        assertThat(MaxAncestorDiff.maxAncestorDiff(root), is(3));
    }

    @Test
    public void testMaxAncestorDiffComplexCase() {
        final TreeNode root = new TreeNode(8, new TreeNode(3, new TreeNode(1), new TreeNode(6, new TreeNode(4), new TreeNode(7))), new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)));

        assertThat(MaxAncestorDiff.maxAncestorDiff(root), is(7));
    }

}