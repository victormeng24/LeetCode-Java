/**
 * Leetcode - binary_tree_level_order_traversal
 */
package com.victormeng.leetcode.binary_tree_level_order_traversal;

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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, result, 0);
        return result;
    }

    public void dfs(TreeNode node, List<List<Integer>> result, int depth) {
        if (depth == result.size()) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
        }
        result.get(depth).add(node.val);
        if (node.left != null) {
            dfs(node.left, result, depth + 1);
        }
        if (node.right != null) {
            dfs(node.right, result, depth + 1);
        }
    }

}
