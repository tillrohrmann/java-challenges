package org.example;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BinaryTreeTiltTest {

    @Test
    public void testFindTiltSimpleCase() {
        final TreeNode tree = TreeNode.inner(1, TreeNode.leave(2), TreeNode.leave(3));

        final int tilt = BinaryTreeTilt.findTilt(tree);

        assertThat(tilt, is(1));
    }

    @Test
    public void testFindTiltComplexCase() {
        final TreeNode tree = TreeNode.inner(21, TreeNode.inner(7, TreeNode.inner(1, TreeNode.leave(3), TreeNode.leave(3)), TreeNode.leave(1)), TreeNode.inner(14, TreeNode.leave(2), TreeNode.leave(2)));
        final int tilt = BinaryTreeTilt.findTilt(tree);
        assertThat(tilt, is(9));
    }

    public static Matcher<TreeNode> matchesTree(TreeNode expected) {
        return new TreeMatcher(expected);
    }

    public static class TreeMatcher extends TypeSafeMatcher<TreeNode> {

        private final TreeNode expected;

        public TreeMatcher(TreeNode expected) {
            this.expected = expected;
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("Expected tree ").appendValue(treeToString(expected));
        }

        private String treeToString(TreeNode expected) {
            return "[" + preOrder(expected) + "]";
        }

        private String preOrder(TreeNode expected) {
            if (expected != null) {
                return expected.getVal() + ", " + preOrder(expected.getLeft()) + ", " + preOrder(expected.getRight());
            } else {
                return "null";
            }
        }

        @Override
        protected boolean matchesSafely(TreeNode item) {
            return matchTrees(expected, item);
        }

        private boolean matchTrees(TreeNode expected, TreeNode item) {
            if (expected != null && item != null) {
                return expected.getVal() == item.getVal() && matchTrees(expected.getLeft(), item.getLeft()) && matchTrees(expected.getRight(), item.getRight());
            } else {
                return expected == item;
            }
        }
    }
}