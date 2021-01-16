/**
 * Leetcode - palindromic_substrings
 */
package com.victormeng.leetcode.palindromic_substrings;

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

    public int countSubstrings(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }

        int iMax = 0, rMax = 0;
        int ret = 0;
        int[] dp = new int[sb.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = i <= rMax ? Math.min(dp[2 * iMax - i], rMax - i + 1) : 0;
            while (i + dp[i] < sb.length()
                    && i - dp[i] >= 0 && sb.charAt(i + dp[i]) == sb.charAt(i - dp[i])) {
                dp[i]++;
            }
            if (i + dp[i] - 1 > rMax) {
                rMax = i + dp[i] - 1;
                iMax = i;
            }
            ret += dp[i] / 2;
        }
        return ret;

    }

    public static void main(String[] args) {
        System.out.println(new Solution1().countSubstrings("abc"));
    }
}
