/**
 * Leetcode - trapping_rain_water
 */
package com.victormeng.leetcode.trapping_rain_water;

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

    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int ret = 0;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                ret += leftMax - height[left];
                left++;
            } else {
                ret += rightMax - height[right];
                right--;
            }
        }
        return ret;
    }

}
