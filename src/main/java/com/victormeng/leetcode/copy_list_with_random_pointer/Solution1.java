/**
 * Leetcode - copy_list_with_random_pointer
 */
package com.victormeng.leetcode.copy_list_with_random_pointer;

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

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node pt = head;
        while (pt != null) {
            Node copy = new Node(pt.val);
            copy.next = pt.next;
            pt.next = copy;
            pt = pt.next.next;
        }
        //  copy random pointer
        pt = head;
        while (pt != null) {
            if (pt.random != null) {
                pt.next.random = pt.random.next;
            }
            pt = pt.next.next;
        }
        Node oldPt = head;
        Node newNode = head.next;
        Node newPt = newNode;
        while (oldPt != null) {
            oldPt.next = newPt.next;
            oldPt = oldPt.next;
            newPt.next = oldPt == null ? null : oldPt.next;
            newPt = newPt.next;
        }
        return newNode;
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
