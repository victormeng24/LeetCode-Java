/**
 * Leetcode - remove_linked_list_elements
 */
package com.victormeng.leetcode.remove_linked_list_elements;

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

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, nxt = head;
        while (nxt != null) {
            if (nxt.val == val) {
                pre.next = nxt.next;
            } else {
                pre = pre.next;
            }
            nxt = nxt.next;
        }
        return dummy.next;
    }

}
