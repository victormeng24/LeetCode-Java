/**
 * Leetcode - swap_nodes_in_pairs
 */
package com.victormeng.leetcode.swap_nodes_in_pairs;

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

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, n1 = head, n2 = head.next;
        while (n2 != null) {
            ListNode tmp = n2.next;
            n2.next = n1;
            n1.next = tmp;
            pre.next = n2;

            pre = n1;
            n1 = tmp;
            if (tmp != null) {
                n2 = tmp.next;
            } else {
                n2 = null;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
        ListNode n = new Solution1().swapPairs(head);
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

}
