/**
 * Leetcode - find_minimum_in_rotate_sorted_array
 */
package com.victormeng.leetcode.find_minimum_in_rotate_sorted_array;

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

    public int findMin(int[] nums) {
        int begin = 0, end = nums.length - 1;
        while (begin < end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                begin = mid + 1;
            }
        }
        return nums[begin];
    }

}
