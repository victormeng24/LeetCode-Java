/**
 * Leetcode - kth_node_from_end_of_list_lcci
 */
package com.victormeng.leetcode.kth_node_from_end_of_list_lcci;

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

    // 1->2->3->4->5
    public int kthToLast(ListNode head, int k) {
        ListNode slow = head, fast = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.val;
    }

}
