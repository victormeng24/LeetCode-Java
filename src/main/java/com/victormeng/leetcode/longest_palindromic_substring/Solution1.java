/**
 * Leetcode - longest_palindromic_substring
 */
package com.victormeng.leetcode.longest_palindromic_substring;

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

    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append('#');
        }
        int[] dp = new int[sb.length()];
        int iMax = 0, rMax = 0;
        int maxLen = 0, start = -1;
        for (int i = 0; i < sb.length(); i++) {
            dp[i] = i <= rMax ? Math.min(rMax - i + 1, dp[2 * iMax - i]) : 0;
            while (i - dp[i] >= 0 && i + dp[i] < sb.length() && sb.charAt(i - dp[i]) == sb.charAt(i + dp[i])) {
                dp[i]++;
            }
            if (i + dp[i] - 1 > rMax) {
                iMax = i;
                rMax = i + dp[i] - 1;
            }
            if (dp[i] - 1 > maxLen) {
                maxLen = dp[i] - 1;
                start = (i - maxLen) / 2;
            }
        }
        return s.substring(start, start + maxLen);
    }
}
