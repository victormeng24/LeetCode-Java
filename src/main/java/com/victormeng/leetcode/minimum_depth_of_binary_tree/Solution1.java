/**
 * Leetcode - minimum_depth_of_binary_tree
 */
package com.victormeng.leetcode.minimum_depth_of_binary_tree;

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

    int ret;

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ret = Integer.MAX_VALUE;
        dfs(root, 1);
        return ret;
    }

    public void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (depth >= ret) {
            return;
        }
        if (root.left == null && root.right == null) {
            ret = Math.min(ret, depth);
        }
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }

}
