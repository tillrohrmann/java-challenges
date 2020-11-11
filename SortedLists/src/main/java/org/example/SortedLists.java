package org.example;

/**
 * Hello world!
 */
public class SortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        ListNode last = null;

        while (true) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = -1;

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && minValue > lists[i].val) {
                    minValue = lists[i].val;
                    minIndex = i;
                }
            }

            if (minIndex != -1) {
                if (result == null) {
                    result = lists[minIndex];
                    lists[minIndex] = result.next;
                    result.next = null;
                    last = result;
                } else {
                    last.next = lists[minIndex];
                    lists[minIndex] = lists[minIndex].next;
                    last = last.next;
                    last.next = null;
                }
            } else {
                break;
            }
        }

        return result;
    }
}
