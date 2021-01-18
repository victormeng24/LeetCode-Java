/**
 * Leetcode - single_number_iii
 */
package com.victormeng.leetcode.single_number_iii;

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

    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int num : nums) {
            bitmask ^= num;
        }
        int diff = bitmask & (-bitmask);
        int num1 = 0;
        for (int num : nums) {
            if ((num & diff) != 0) {
                num1 ^= num;
            }
        }
        return new int[]{num1, bitmask ^ num1};
    }

}
