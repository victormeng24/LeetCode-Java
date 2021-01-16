/**
 * Leetcode - ba_shu_zi_fan_yi_cheng_zi_fu_chuan_lcof
 */
package com.victormeng.leetcode.ba_shu_zi_fan_yi_cheng_zi_fu_chuan_lcof;

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
class Solution2 implements Solution {

    public int translateNum(int num) {
        String s = String.valueOf(num);
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] += dp[i - 1];
            if (s.charAt(i - 2) != '0') {
                int ten = s.charAt(i - 2) - '0';
                int one = s.charAt(i - 1) - '0';
                if (ten * 10 + one <= 25) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().translateNum(12258));
    }

}
