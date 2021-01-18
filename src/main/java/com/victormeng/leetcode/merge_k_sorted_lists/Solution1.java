/**
 * Leetcode - merge_k_sorted_lists
 */
package com.victormeng.leetcode.merge_k_sorted_lists;

import java.util.*;

import com.ciaoshen.leetcode.util.*;

/**
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 * if (log.isDebugEnabled()) {
 * log.debug("a + b = {}", sum);
 * }
 * =============================================
 */
class Solution1 implements Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode pt = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            pt.next = node;
            pt = pt.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return dummy.next;
    }

}
