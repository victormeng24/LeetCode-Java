/**
 * Leetcode - binary_tree_post_order_traversal
 */
package com.victormeng.leetcode.binary_tree_post_order_traversal;

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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root, pre = null;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.peek();
            if (node.right == null || pre == node.right) {
                stack.pop();
                ret.add(node.val);
                pre = node;
                cur = null;
            } else {
                cur = node.right;
            }
        }
        return ret;
    }

}
