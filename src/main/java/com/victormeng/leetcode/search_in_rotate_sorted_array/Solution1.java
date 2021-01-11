/**
 * Leetcode - search_in_rotate_sorted_array
 */
package com.victormeng.leetcode.search_in_rotate_sorted_array;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution1 implements Solution {

    public int search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] == target) return mid;
            if (nums[begin] <= nums[mid]) {
                if (nums[mid] > target && target >= nums[begin]) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[end]) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }

}
