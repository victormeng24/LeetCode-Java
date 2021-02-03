/**
 * Leetcode - boundary_of_binary_tree
 */
package com.victormeng.leetcode.boundary_of_binary_tree;

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

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, true, true, res);
        return res;
    }

    private void dfs(TreeNode node, boolean leftBound, boolean rightBound, List<Integer> res) {
        if (node == null) {
            return;
        }
        if (leftBound) {
            res.add(node.val);
        } else if (node.left == null && node.right == null) {
            res.add(node.val);
            return;
        }
        dfs(node.left, leftBound, !leftBound && rightBound && node.right == null, res);
        dfs(node.right, !rightBound && leftBound && node.left == null, rightBound, res);
        if (!leftBound && rightBound) {
            res.add(node.val);
        }
    }

}
