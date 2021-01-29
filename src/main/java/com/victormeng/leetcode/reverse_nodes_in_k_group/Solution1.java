/**
 * Leetcode - reverse_nodes_in_k_group
 */
package com.victormeng.leetcode.reverse_nodes_in_k_group;

import java.util.*;

import com.ciaoshen.leetcode.util.*;
import com.victormeng.leetcode.common.ListUtil;

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

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, tail = dummy;
        while (tail != null) {
            for (int i = 0; i < k && tail != null; i++) {
                tail = tail.next;
            }
            if(tail == null) {
                break;
            }
            ListNode start = pre.next;
            pre.next = null;
            ListNode mark = tail.next;
            tail.next = null;

            pre.next = reverse(start);
            start.next = mark;

            pre = tail = start;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head;
        ListNode nxt = head.next;
        pre.next = null;
        while (nxt != null) {
            ListNode tmp = nxt.next;
            nxt.next = pre;
            pre = nxt;
            nxt = tmp;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(new int[]{1, 2, 3, 4, 5});
        ListNode ret = new Solution1().reverseKGroup(head, 3);
        ListUtil.printList(ret);

    }

}
