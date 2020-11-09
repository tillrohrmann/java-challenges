package org.example;

public class BinaryTreeTilt {
    public static int findTilt(TreeNode input) {
        return findTiltForTree(input).tilt;
    }

    private static TiltResult findTiltForTree(TreeNode input) {
        if (input == null) {
            return new TiltResult(0, 0);
        } else {
            final TiltResult left = findTiltForTree(input.left);
            final TiltResult right = findTiltForTree(input.right);

            return new TiltResult(input.val + left.sum + right.sum, Math.abs(left.sum - right.sum) + left.tilt + right.tilt);
        }
    }

    public static class TiltResult {
        final int sum;
        final int tilt;

        public TiltResult(int sum, int tilt) {
            this.sum = sum;
            this.tilt = tilt;
        }
    }

    public static TreeNode findTiltedTree(TreeNode input) {
        return null;
    }
}
