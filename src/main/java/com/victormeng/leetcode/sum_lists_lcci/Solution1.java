/**
 * Leetcode - sum_lists_lcci
 */
package com.victormeng.leetcode.sum_lists_lcci;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution1 implements Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return recurse(l1, l2, 0);
    }

    public ListNode recurse(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        int val1 = l1 == null ? 0 : l1.val;
        int val2 = l2 == null ? 0 : l2.val;
        ListNode head = new ListNode((val1 + val2 + carry) % 10);
        ListNode next = recurse(l1 == null ? null : l1.next,
                l2 == null ? null : l2.next, (val1 + val2 + carry) / 10);
        if (next != null) {
            head.next = next;
        }
        return head;
    }

}
