/**
 * Leetcode - binary_search
 */
package com.victormeng.leetcode.binary_search;

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

    public int search(int[] nums, int target) {
        int begin = 0, end = nums.length - 1;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return -1;
    }

}
