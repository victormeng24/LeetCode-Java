/**
 * Leetcode - remove_duplicates_from_sorted_lists
 */
package com.victormeng.leetcode.remove_duplicates_from_sorted_lists;

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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head, nxt = head.next;
        while (nxt != null) {
            while (nxt != null && nxt.val == pre.val) {
                pre.next = nxt.next;
                nxt = nxt.next;
            }
            pre = pre.next;
            if (nxt != null) {
                nxt = nxt.next;
            }
        }
        return head;
    }

}
