/**
 * Leetcode - reorder_list
 */
package com.victormeng.leetcode.reorder_list;

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

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = findMid(head);
        ListNode secondHalf = reverse(mid.next);
        mid.next = null;
        while (secondHalf != null) {
            ListNode tmp = head.next;
            head.next = secondHalf;
            ListNode secondTmp = secondHalf.next;
            secondHalf.next = tmp;
            head = tmp;
            secondHalf = secondTmp;
        }
    }

    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head, nxt = head.next;
        pre.next = null;
        while (nxt != null) {
            ListNode tmp = nxt.next;
            nxt.next = pre;
            pre = nxt;
            nxt = tmp;
        }
        return pre;
    }

    // 1->2->3<-4
    // 1->2->3<-4<-5
    public ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
