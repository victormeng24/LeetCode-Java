/**
 * Leetcode - construct_binary_tree_from_inorder_and_postorder_traversal
 */
package com.victormeng.leetcode.construct_binary_tree_from_inorder_and_postorder_traversal;
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0) {
            return null;
        }
        int rootVal = postorder[postorder.length - 1];
        int i = 0;
        while (inorder[i] != rootVal) {
            i++;
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(Arrays.copyOfRange(inorder, 0, i),
                Arrays.copyOfRange(postorder, 0, i));
        root.right = buildTree(Arrays.copyOfRange(inorder, i + 1, inorder.length),
                Arrays.copyOfRange(postorder, i, postorder.length - 1));
        return root;
    }

}
