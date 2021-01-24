/**
 * Leetcode - house_rubber_iii
 */
package com.victormeng.leetcode.house_rubber_iii;

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

    public int rob(TreeNode root) {
        int[] ret =  search(root);
        return Math.max(ret[0], ret[1]);
    }

    public int[] search(TreeNode root) {
        if (root == null) {
            return new int[2];
        }
        int[] left = search(root.left);
        int[] right = search(root.right);

        int[] ret = new int[2];
        ret[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        ret[1] = left[0] + right[0] + root.val;
        return ret;
    }

}
