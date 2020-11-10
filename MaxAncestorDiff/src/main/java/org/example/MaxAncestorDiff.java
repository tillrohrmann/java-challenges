package org.example;

import java.util.Arrays;
import java.util.Collections;

/**
 * Hello world!
 */
public class MaxAncestorDiff {
    public static int maxAncestorDiff(TreeNode root) {
        return Math.max(calcMaxAncestorDiff(root.left, root.val, root.val), calcMaxAncestorDiff(root.right, root.val, root.val));
    }

    public static int calcMaxAncestorDiff(TreeNode node, int max, int min) {
        if (node == null) {
            return 0;
        } else {
            final int maxDiff = Math.max(Math.abs(node.val - max), Math.abs(node.val - min));

            final int newMax = Math.max(max, node.val);
            final int newMin = Math.min(min, node.val);

            return Collections.max(Arrays.asList(maxDiff, calcMaxAncestorDiff(node.left, newMax, newMin), calcMaxAncestorDiff(node.right, newMax, newMin)));
        }
    }
}
