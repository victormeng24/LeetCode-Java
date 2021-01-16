/**
 * Leetcode - path_sum_ii
 */
package com.victormeng.leetcode.path_sum_ii;

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
    List<Integer> tmpList;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        tmpList = new ArrayList<>();
        dfs(root, sum);
        return result;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (root.val == sum && root.left == null && root.right == null) {
            result.add(new ArrayList<>(tmpList));
            result.get(result.size() - 1).add(root.val);
            return;
        }
        tmpList.add(root.val);
        dfs(root.left, sum - root.val);
        dfs(root.right, sum - root.val);
        tmpList.remove(tmpList.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        System.out.println(new Solution1().pathSum(root, 22));
    }
}
