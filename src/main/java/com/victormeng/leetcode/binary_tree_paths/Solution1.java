/**
 * Leetcode - binary_tree_paths
 */
package com.victormeng.leetcode.binary_tree_paths;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution1 implements Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, new StringBuilder(), result);
        return result;
    }

    private void dfs(TreeNode root, StringBuilder cur, List<String> paths) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            paths.add(cur.toString() + root.val);
            return;
        }
        int sz = cur.length();
        cur.append(root.val).append("->");
        dfs(root.left, cur, paths);
        dfs(root.right, cur, paths);
        cur.delete(sz, cur.length());
    }

}
