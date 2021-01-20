/**
 * Leetcode - binary_tree_zigzag_level_order_traversal
 */
package com.victormeng.leetcode.binary_tree_zigzag_level_order_traversal;

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

    List<List<Integer>> result;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, 0);
        return result;
    }

    public void dfs(TreeNode root, int depth) {
        if (depth == result.size()) {
            List<Integer> list = new ArrayList<>();
            result.add(list);
        }
        if (depth % 2 == 0) {
            result.get(depth).add(root.val);
        } else {
            result.get(depth).add(0, root.val);
        }
        if (root.left != null) {
            dfs(root.left, depth + 1);
        }
        if (root.right != null) {
            dfs(root.right, depth + 1);
        }
    }

}
