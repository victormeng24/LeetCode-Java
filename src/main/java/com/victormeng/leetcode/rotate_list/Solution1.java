/**
 * Leetcode - rotate_list
 */
package com.victormeng.leetcode.rotate_list;

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

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        k = k % len;
        if (k == 0) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int toMove = len - k;
        ListNode pointer = dummy;
        while (toMove-- > 0) {
            pointer = pointer.next;
        }
        ListNode newHead = pointer.next;
        pointer.next = null;
        dummy.next = newHead;
        tail.next = head;
        return dummy.next;
    }

}
