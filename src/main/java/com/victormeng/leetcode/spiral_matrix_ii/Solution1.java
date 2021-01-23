/**
 * Leetcode - spiral_matrix_ii
 */
package com.victormeng.leetcode.spiral_matrix_ii;

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

    public int[][] generateMatrix(int n) {
        int mx = 0, nx = n - 1, my = 0, ny = n - 1;
        int[][] ret = new int[n][n];
        int scanner = 1;
        while (mx <= nx && my <= ny) {
            for (int i = my; i <= ny; i++) {
                ret[mx][i] = scanner++;
            }
            mx++;
            for (int i = mx; i <= nx; i++) {
                ret[i][ny] = scanner++;
            }
            ny--;
            for (int i = ny; i >= my && mx <= nx; i--) {
                ret[nx][i] = scanner++;
            }
            nx--;
            for (int i = nx; i >= mx && my <= ny; i--) {
                ret[i][my] = scanner++;
            }
            my++;
        }
        return ret;
    }

}
