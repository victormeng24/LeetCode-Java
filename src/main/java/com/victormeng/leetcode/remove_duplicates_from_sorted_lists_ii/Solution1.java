/**
 * Leetcode - remove_duplicates_from_sorted_lists_ii
 */
package com.victormeng.leetcode.remove_duplicates_from_sorted_lists_ii;

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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, nxt = head;
        while (nxt != null) {
            ListNode pt = nxt;
            while (pt.next != null && pt.next.val == nxt.val) {
                pt = pt.next;
            }
            if (pt == nxt) {
                pre = pre.next;
                nxt = nxt.next;
            } else {
                pre.next = pt.next;
                nxt = pt.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = ListUtil.buildList(new int[]{1, 1, 1, 2, 3});
        ListNode n = new Solution1().deleteDuplicates(head);
        ListUtil.printList(n);
    }

}
