package org.example;

import com.sun.istack.internal.Nullable;

public class TreeNode {
    final int val;

    @Nullable
    final TreeNode left;

    @Nullable
    final TreeNode right;

    private TreeNode(int val, @Nullable TreeNode left, @Nullable TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode inner(int value, TreeNode left, TreeNode right) {
        return new TreeNode(value, left, right);
    }

    public static TreeNode leave(int value) {
        return new TreeNode(value, null, null);
    }

    public static TreeNode empty() {
        return null;
    }
}
