package org.example;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

    @Test
    public void testReverseKGroup() {
        final Solution.ListNode list = Solution.ListNode.from(new int[]{1, 2, 3, 4, 5});

        final Solution.ListNode result = Solution.reverseKGroup(list, 2);

        assertThat(result.toArray(), is(new int[]{2, 1, 4, 3, 5}));
    }

}