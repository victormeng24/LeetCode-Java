/**
 * Leetcode - find_all_duplicates_in_an_array
 */
package com.victormeng.leetcode.find_all_duplicates_in_an_array;

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

    // [4,3,2,7,8,2,3,1]
    // 4,3,2,7,-8,2,3,1
    // 4,3,2,-7,-8,2,3,1
    // 4,3,-2,-7,-8,2,3,1
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            int index = val % nums.length;
            if (nums[index] < 0) {
                result.add(val);
            } else {
                nums[index] = -nums[index];
            }
        }
        return result;
    }
}
