/**
 * Leetcode - transpose_matrix
 */
package com.victormeng.leetcode.transpose_matrix;

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

    public int[][] transpose(int[][] A) {
        if (A.length == 0 || A[0].length == 0) {
            return null;
        }
        int[][] ret = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                ret[j][i] = A[i][j];
            }
        }
        return ret;
    }

}
