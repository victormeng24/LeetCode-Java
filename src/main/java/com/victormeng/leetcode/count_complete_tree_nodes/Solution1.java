/**
 * Leetcode - count_complete_tree_nodes
 */
package com.victormeng.leetcode.count_complete_tree_nodes;

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

    public int countDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            depth++;
            root = root.left;
        }
        return depth;
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = countDepth(root.left);
        int right = countDepth(root.right);
        if (left == right) {
            return countNodes(root.right) + (1 << left);
        } else {
            return countNodes(root.left) + (1 << right);
        }
    }

}
