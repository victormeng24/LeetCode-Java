/**
 * Leetcode - maximum_product_subarray
 */
package com.victormeng.leetcode.maximum_product_subarray;

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

    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        Arrays.fill(max, Integer.MIN_VALUE);
        Arrays.fill(min, Integer.MAX_VALUE);
        max[0] = nums[0];
        min[0] = nums[0];
        int ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(nums[i], Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]));
            if (ret < max[i]) {
                ret = max[i];
            }
            min[i] = Math.min(nums[i], Math.min(min[i - 1] * nums[i], max[i - 1] * nums[i]));
        }
        return ret;
    }
}
