/**
 * Leetcode - sum_of_left_leaves
 */
package com.victormeng.leetcode.sum_of_left_leaves;

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

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sumLeft = hasLeftLeave(root) ? root.left.val : sumOfLeftLeaves(root.left);
        return sumLeft + sumOfLeftLeaves(root.right);
    }

    public boolean hasLeftLeave(TreeNode node) {
        return node.left != null && node.left.left == null && node.left.right == null;
    }


}
