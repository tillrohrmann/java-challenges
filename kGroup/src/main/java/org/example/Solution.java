package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class Solution {
    public static ListNode reverseKGroup(ListNode head, int k) {
        final ListNode start = new ListNode(-1, head);

        ListNode left = start;
        ListNode right = start;

        while (true) {
            right = moveStepsAhead(right, k);

            if (right == null) {
                break;
            }

            final ListNode next = right.next;
            final ListNode kStart = left.next;

            reverseSubList(kStart, right);

            kStart.next = next;
            left.next = right;

            left = kStart;
            right = left;
        }

        return start.next;
    }

    private static void reverseSubList(ListNode start, ListNode end) {
        final ListNode terminationNode = end.next;
        ListNode revStart = null;
        ListNode current = start;

        while (current != terminationNode) {
            ListNode next = current.next;

            current.next = revStart;
            revStart = current;
            current = next;
        }
    }

    private static ListNode moveStepsAhead(ListNode start, int k) {
        for (int i = 0; i < k && start != null; i++) {
            start = start.next;
        }

        return start;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
            this(-1, null);
        }

        public ListNode(int val) {
            this(val, null);
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public static ListNode from(int[] values) {
            ListNode result = null;

            for (int i = values.length - 1; i >= 0; i--) {
                result = new ListNode(values[i], result);
            }

            return result;
        }

        public int[] toArray() {
            ListNode current = this;
            List<Integer> values = new ArrayList<>();

            while (current != null) {
                values.add(current.val);
                current = current.next;
            }

            final int[] result = new int[values.size()];

            for (int i = 0; i < values.size(); i++) {
                result[i] = values.get(i);
            }

            return result;
        }
    }
}
