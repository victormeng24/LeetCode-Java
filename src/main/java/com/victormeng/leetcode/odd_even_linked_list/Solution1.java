/**
 * Leetcode - odd_even_linked_list
 */
package com.victormeng.leetcode.odd_even_linked_list;

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

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head, even = head.next;
        ListNode ptO = odd, ptE = even;
        while(ptE != null && ptE.next != null) {
            ptO.next = ptO.next.next;
            ptE.next = ptE.next.next;
            ptO = ptO.next;
            ptE = ptE.next;
        }
        ptO.next = even;
        return head;
    }
}
