/**
 * Leetcode - lian_xu_zi_shu_zu_de_zui_da_he_lcof
 */
package com.victormeng.leetcode.lian_xu_zi_shu_zu_de_zui_da_he_lcof;

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

    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
            if(nums[i] > ret) {
                ret = nums[i];
            }
        }
        return ret;
    }

}
