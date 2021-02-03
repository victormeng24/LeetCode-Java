/**
 * Leetcode - binary_tree_vertical_order_traversal
 */
package com.victormeng.leetcode.binary_tree_vertical_order_traversal;
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

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        // 存放当前位置(key)的结果集(value)
        Map<Integer, List<Integer>> res = new TreeMap<>();

        // 存放当前节点（TreeNode）的位置
        Map<TreeNode, Integer> nodeMap = new HashMap<>();
        nodeMap.put(root, 0);

        // 层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int i = nodeMap.get(node);
            // 如果当前位置还没有存储元素的结果集，则初始化 value，并添加元素
            res.computeIfAbsent(i, k -> new ArrayList<>()).add(node.val);
            // 左边向下逐层减 1
            if (node.left != null) {
                queue.add(node.left);
                nodeMap.put(node.left, i - 1);
            }
            // 右边向下逐层加 1
            if (node.right != null) {
                queue.add(node.right);
                nodeMap.put(node.right, i + 1);
            }
        }
        return new ArrayList<>(res.values());
    }

}
