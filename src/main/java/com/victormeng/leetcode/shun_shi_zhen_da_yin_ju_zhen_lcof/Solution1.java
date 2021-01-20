/**
 * Leetcode - shun_shi_zhen_da_yin_ju_zhen_lcof
 */
package com.victormeng.leetcode.shun_shi_zhen_da_yin_ju_zhen_lcof;

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

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int[] result = new int[matrix.length * matrix[0].length];
        int index = 0;
        int mx = 0, nx = matrix.length - 1, my = 0, ny = matrix[0].length - 1;
        while (mx <= nx && my <= ny) {
            for (int i = my; i <= ny; i++) {
                result[index++] = matrix[mx][i];
            }
            mx++;
            for (int i = mx; i <= nx; i++) {
                result[index++] = matrix[i][ny];
            }
            ny--;
            for (int i = ny; i >= my && mx <= nx; i--) {
                result[index++] = matrix[nx][i];
            }
            nx--;
            for (int i = nx; i >= mx && my <= ny; i--) {
                result[index++] = matrix[i][my];
            }
            my++;
        }
        return result;
    }

}
