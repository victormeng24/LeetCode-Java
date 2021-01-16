/**
 * Leetcode - diameter_of_binary_tree
 */
package com.victormeng.leetcode.diameter_of_binary_tree;

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

    int maxLen = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        tarverse(root);
        return maxLen;
    }

    public int tarverse(TreeNode root) {
        if (root == null) return 0;
        int maxLeft = tarverse(root.left);
        int maxRight = tarverse(root.right);
        maxLen = Math.max(maxLen, maxLeft + maxRight);
        return Math.max(1 + maxLeft, 1 + maxRight);
    }
}
