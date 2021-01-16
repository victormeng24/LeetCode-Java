/**
 * Leetcode - sort_colors
 */
package com.victormeng.leetcode.sort_colors;

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

    public void sortColors(int[] nums) {
        int i = 0, j = nums.length - 1, pt = 0;
        while (pt <= j) {
            if (nums[pt] == 0) {
                swap(nums, i++, pt++);
            } else if (nums[pt] == 2) {
                swap(nums, j--, pt);
            } else {
                pt++;
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
