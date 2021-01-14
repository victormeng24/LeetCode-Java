/**
 * Leetcode - balanced_binary_tree
 */
package com.victormeng.leetcode.balanced_binary_tree;

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

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int left = getHeight(root.left);
        if (left == -1) {
            return false;
        }
        int right = getHeight(root.right);
        if (right == -1) {
            return false;
        }
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return true;
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getHeight(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getHeight(root.right);
        if (right == -1) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }

}
