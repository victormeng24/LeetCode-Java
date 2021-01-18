/**
 * Leetcode - three_sum
 */
package com.victormeng.leetcode.three_sum;

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

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int begin = i + 1, end = len - 1;
            int ptB = begin, ptE = end;
            int tar = -nums[i];
            while (ptB < ptE) {
                if (ptB > begin && nums[ptB] == nums[ptB - 1]) {
                    ptB++;
                    continue;
                }
                int sum = nums[ptB] + nums[ptE];
                if (sum == tar) {
                    result.add(Arrays.asList(nums[i], nums[ptB], nums[ptE]));
                    ptB++;
                    ptE--;
                } else if (sum > tar) {
                    ptE--;
                } else {
                    ptB++;
                }
            }
        }
        return result;
    }
}
