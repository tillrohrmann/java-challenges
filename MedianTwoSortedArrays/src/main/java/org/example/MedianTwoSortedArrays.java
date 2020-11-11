package org.example;

/**
 * Hello world!
 *
 */
public class MedianTwoSortedArrays
{
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length <= nums2.length) {
            return findMedianSortedArrays(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1);
        } else {
            return findMedianSortedArrays(nums2, 0, nums2.length - 1, nums1, 0, nums1.length - 1);
        }
    }

    private static double findMedianSortedArrays(int[] left, int startLeft, int endLeft, int[] right, int startRight, int endRight) {
        final int leftLength = endLeft - startLeft + 1;

        if (leftLength <= 2) {
            assert left.length <= right.length;

            final int difference = endRight - startRight;
            final int medianIndex = startRight + difference / 2;
            final boolean isOdd = (difference % 2) == 0;
            final int rightMedian = right[medianIndex];

            if (leftLength == 0) {
                if (isOdd) {
                    return right[medianIndex];
                } else {
                    return (right[medianIndex] + right[medianIndex + 1]) / 2.0;
                }
            } else if (leftLength == 1) {
                if (isOdd) {
                    final int other;

                    if (left[startLeft] <= rightMedian) {
                        other = Math.max(left[startLeft], medianIndex - 1 >= 0 ? right[medianIndex - 1] : Integer.MIN_VALUE);
                    } else {
                        other = Math.min(left[startLeft], medianIndex + 1 < right.length ? right[medianIndex + 1] : Integer.MAX_VALUE);
                    }

                    return (rightMedian + other) / 2.0;
                } else {
                    if (left[startLeft] <= rightMedian) {
                        return rightMedian;
                    } else {
                        return Math.min(left[startLeft], medianIndex + 1 < right.length ? right[medianIndex + 1] : Integer.MAX_VALUE);
                    }
                }
            } else {
                final int left1 = left[startLeft];
                final int left2 = left[startLeft + 1];

                if (isOdd) {
                    if (left1 <= rightMedian && rightMedian <= left2) {
                        return rightMedian;
                    } else {
                        if (left2 < rightMedian) {
                            return Math.max(left2, medianIndex - 1 >= 0 ? right[medianIndex - 1] : Integer.MIN_VALUE);
                        } else {
                            return Math.min(left1, medianIndex + 1 < right.length ? right[medianIndex + 1] : Integer.MAX_VALUE);
                        }
                    }
                } else {
                    if (left2 <= rightMedian) {
                        final int other = Math.max(left2, medianIndex - 1 >= 0 ? right[medianIndex - 1] : Integer.MIN_VALUE);
                        return (other + rightMedian) / 2.0;
                    } else if (left1 <= rightMedian && rightMedian < left2) {
                        final int other =  Math.min(left2, medianIndex + 1 < right.length ? right[medianIndex + 1] : Integer.MAX_VALUE);
                        return (other + rightMedian) / 2.0;
                    } else if (rightMedian < left1) {
                        final int median1 = Math.min(left1, medianIndex + 1 < right.length ? right[medianIndex + 1] : Integer.MAX_VALUE);

                        final int median2;
                        if (median1 == left1) {
                            median2 = Math.min(left2, medianIndex + 1 < right.length ? right[medianIndex + 1] : Integer.MAX_VALUE);
                        } else {
                            median2 = Math.min(left1, medianIndex + 2 < right.length ? right[medianIndex + 2] : Integer.MAX_VALUE);
                        }

                        return (median1 + median2) / 2.0;
                    } else {
                        throw new IllegalStateException("Should not happen.");
                    }
                }
            }
        } else {
            assert left.length > 2 && right.length > 2;
            final int middleLeft = (endLeft + startLeft) / 2;
            final int middleRight = (endRight + startRight) / 2;

            final int pivotLeft = left[middleLeft];
            final int pivotRight = right[middleRight];

            final int rightEven = ((endRight - startRight) % 2) == 1 ? 1 : 0;
            final int leftEven = ((endLeft - startLeft) % 2) == 1 ? 1 : 0;
            if (pivotLeft <= pivotRight) {
                final int cutoff = Math.min(middleLeft - startLeft, endRight - middleRight - rightEven);
                return findMedianSortedArrays(left, startLeft + cutoff, endLeft, right, startRight, endRight - cutoff);
            } else {
                final int cutoff = Math.min(endLeft - middleLeft - leftEven, middleRight - startRight);
                return findMedianSortedArrays(left, startLeft, endLeft - cutoff, right, startRight + cutoff, endRight);
            }
        }
    }
}
