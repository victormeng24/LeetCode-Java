/**
 * Leetcode - intersection_of_two_linked_lists_lcci
 */
package com.victormeng.leetcode.intersection_of_two_linked_lists_lcci;

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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA, t2 = headB;
        while (t1 != t2) {
            if (t1 != null) {
                t1 = t1.next;
            } else {
                t1 = headB;
            }
            if (t2 != null) {
                t2 = t2.next;
            } else {
                t2 = headA;
            }
        }
        return t1;
    }

}
