/**
 * Leetcode - UlBDOe
 */
package com.victormeng.leetcode.UlBDOe;

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

    public int minimumOperations(String leaves) {
        int[][] dp = new int[leaves.length()][3];
        dp[0][0] = leaves.charAt(0) == 'r' ? 0 : 1;
        dp[0][1] = dp[0][2] = dp[1][2] = Integer.MAX_VALUE;
        for (int i = 1; i < leaves.length(); i++) {
            char c = leaves.charAt(i);
            int red = c == 'r' ? 0 : 1;
            int yellow = c == 'y' ? 0 : 1;
            dp[i][0] = dp[i - 1][0] + red;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + yellow;
            if (i > 1) {
                dp[i][2] = Math.min(dp[i - 1][2], dp[i - 1][1]) + red;
            }
        }
        return dp[leaves.length() - 1][2];
    }

}
