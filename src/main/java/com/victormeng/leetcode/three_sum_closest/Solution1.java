/**
 * Leetcode - three_sum_closest
 */
package com.victormeng.leetcode.three_sum_closest;

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

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int ret = Integer.MAX_VALUE;
        int sumRet = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int begin = i + 1, end = len - 1;
            int ptB = begin, ptE = end;
            while (ptB < ptE) {
                if (ptB > begin && nums[ptB] == nums[ptB - 1]) {
                    ptB++;
                    continue;
                }
                int sum = nums[i] + nums[ptB] + nums[ptE];
                if (Math.abs(sum - target) < ret) {
                    sumRet = sum;
                    ret = Math.abs(sum - target);
                }
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    ptE--;
                } else {
                    ptB++;
                }
            }
        }
        return sumRet;
    }
}
