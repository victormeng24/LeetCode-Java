/**
 * Leetcode - decode_ways
 */
package com.victormeng.leetcode.decode_ways;

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

    public int numDecodings(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (s.charAt(i - 2) != '0') {
                int code = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
                if (code <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().numDecodings("0"));
    }

}
