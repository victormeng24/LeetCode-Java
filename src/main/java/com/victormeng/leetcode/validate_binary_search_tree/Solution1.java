/**
 * Leetcode - validate_binary_search_tree
 */
package com.victormeng.leetcode.validate_binary_search_tree;

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

    public boolean isValidBST(TreeNode root) {
        return validHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean validHelper(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val <= minVal || root.val >= maxVal) return false;
        return validHelper(root.left, minVal, root.val)
                && validHelper(root.right, root.val, maxVal);
    }

}
