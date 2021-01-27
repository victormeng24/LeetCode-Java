/**
 * Leetcode - shu_de_zi_jie_gou_lcof
 */
package com.victormeng.leetcode.shu_de_zi_jie_gou_lcof;

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

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (search(A, B)
                || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean search(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return search(A.left, B.left) && search(A.right, B.right);
    }

}
