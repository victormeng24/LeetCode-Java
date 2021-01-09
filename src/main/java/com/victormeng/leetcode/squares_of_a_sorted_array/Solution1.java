/**
 * Leetcode - squares_of_a_sorted_array
 */
package com.victormeng.leetcode.squares_of_a_sorted_array;

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

    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int mark = 0;
        while (i < nums.length && nums[i] < 0) {
            mark = i;
            i++;
        }
        int j = mark, k = mark + 1;
        int[] ret = new int[nums.length];
        int index = 0;
        while (j >= 0 && k < nums.length) {
            int jAbs = Math.abs(nums[j]);
            int kAbs = Math.abs(nums[k]);
            if (jAbs > kAbs) {
                k++;
                ret[index++] = kAbs * kAbs;
            } else {
                j--;
                ret[index++] = jAbs * jAbs;
            }
        }
        while (j >= 0) {
            ret[index++] = nums[j] * nums[j];
            j--;
        }
        while (k < nums.length) {
            ret[index++] = nums[k] * nums[k];
            k++;
        }
        return ret;
    }

}
