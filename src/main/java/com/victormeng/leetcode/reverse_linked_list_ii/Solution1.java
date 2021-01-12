/**
 * Leetcode - reverse_linked_list_ii
 */
package com.victormeng.leetcode.reverse_linked_list_ii;
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

    // 1->2->3->4->5
    // m=2, n = 4
    // pt -> 1
    // reverse 2->3->4
    // list now become to 1->2<-3<-4->5
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int len = n - m;
        ListNode pt = dummy;
        while (--m > 0) {
            pt = pt.next;
        }
        ListNode roHead = pt.next, roNext = roHead.next;
        roHead.next = null;
        while (len-- > 0) {
            ListNode tmp = roNext.next;
            roNext.next = roHead;
            roHead = roNext;
            roNext = tmp;
        }
        ListNode roTail = pt.next;
        pt.next = roHead;
        roTail.next = roNext;
        return dummy.next;
    }

}
