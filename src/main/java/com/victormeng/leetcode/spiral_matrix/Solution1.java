/**
 * Leetcode - spiral_matrix
 */
package com.victormeng.leetcode.spiral_matrix;

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

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int mx = 0, nx = matrix.length - 1, my = 0, ny = matrix[0].length - 1;
        while (mx <= nx && my <= ny) {
            for (int i = my; i <= ny; i++) {
                result.add(matrix[mx][i]);
            }
            mx++;
            for (int i = mx; i <= nx; i++) {
                result.add(matrix[i][ny]);
            }
            ny--;
            for (int i = ny; i >= my && mx <= nx; i--) {
                result.add(matrix[nx][i]);
            }
            nx--;
            for (int i = nx; i >= mx && my <= ny; i--) {
                result.add(matrix[i][my]);
            }
            my++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(new Solution1().spiralOrder(matrix));
    }

}
