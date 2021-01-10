/**
 * Leetcode - majority_element
 */
package com.victormeng.leetcode.majority_element;

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

    public int majorityElement(int[] nums) {
        int ret = nums[0], cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ret) {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                ret = nums[i];
                cnt = 1;
            }
        }
        return ret;
    }

}
