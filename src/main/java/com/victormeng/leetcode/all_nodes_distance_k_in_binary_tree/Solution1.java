/**
 * Leetcode - all_nodes_distance_k_in_binary_tree
 */
package com.victormeng.leetcode.all_nodes_distance_k_in_binary_tree;

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

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        Map<TreeNode, TreeNode> nodeToParentMap = new HashMap<>();
        dfs(root, null, nodeToParentMap);
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        int distance = 0;
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        while (!queue.isEmpty()) {
            if (distance == K) {
                while (!queue.isEmpty()) {
                    ret.add(queue.poll().val);
                }
                return ret;
            }
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    visited.add(node.left);
                    queue.offer(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    visited.add(node.right);
                    queue.offer(node.right);
                }
                if (nodeToParentMap.get(node) != null
                        && !visited.contains(nodeToParentMap.get(node))) {
                    visited.add(nodeToParentMap.get(node));
                    queue.offer(nodeToParentMap.get(node));
                }
            }
            distance++;
        }
        return ret;
    }

    public void dfs(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> map) {
        if (node != null) {
            map.put(node, parent);
            dfs(node.left, node, map);
            dfs(node.right, node, map);
        }
    }

}
