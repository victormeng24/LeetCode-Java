/**
 * Leetcode - convert_binary_search_tree_to_sorted_doubly_linked_list
 */
package com.victormeng.leetcode.convert_binary_search_tree_to_sorted_doubly_linked_list;

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

    Node pre = null;
    Node head = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        helper(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    public void helper(Node root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (pre == null) {
            head = root;
        } else {
            root.left = pre;
            pre.right = root;
        }
        pre = root;
        helper(root.right);
    }

}
