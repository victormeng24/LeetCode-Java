/**
 * Leetcode - reverse_linked_list
 */
package com.victormeng.leetcode.reverse_linked_list;
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

    public ListNode reverseList(ListNode head) {
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

}
