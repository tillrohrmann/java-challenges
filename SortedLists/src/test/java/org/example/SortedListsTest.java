package org.example;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class SortedListsTest {
    @Test
    public void testSimpleEmptySortingCase() {
        final ListNode listNode = SortedLists.mergeKLists(new ListNode[0]);

        assertThat(listNode, is(nullValue()));
    }

    @Test
    public void testSorting() {
        final ListNode mergedList = SortedLists.mergeKLists(new ListNode[]{
                ListNode.fromCollection(Arrays.asList(1, 4, 5)),
                ListNode.fromCollection(Arrays.asList(1, 3, 4)),
                ListNode.fromCollection(Arrays.asList(2, 6))});

        assertThat(mergedList.toList(), is(Arrays.asList(1, 1, 2, 3, 4, 4, 5, 6)));
    }
}