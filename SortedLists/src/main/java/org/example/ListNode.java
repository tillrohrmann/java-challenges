package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public List<Integer> toList() {
        final ArrayList<Integer> result = new ArrayList<>();

        ListNode current = this;

        while (current != null) {
            result.add(current.val);
            current = current.next;
        }

        return result;
    }

    public static ListNode fromCollection(Collection<Integer> integers) {
        ListNode result = null;
        ListNode last = null;

        for (int value : integers) {
            if (result == null) {
                result = new ListNode(value);
                last = result;
            } else {
                last.next = new ListNode(value);
                last = last.next;
            }
        }

        return result;
    }
}
