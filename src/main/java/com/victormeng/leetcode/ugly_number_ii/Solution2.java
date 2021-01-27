/**
 * Leetcode - ugly_number_ii
 */
package com.victormeng.leetcode.ugly_number_ii;

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

    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for (int i = 1; i < n; i++) {
            int num = Math.min(Math.min(dp[i2] * 2, dp[i3] * 3), dp[i5] * 5);
            dp[i] = num;
            if (dp[i2] * 2 == num) {
                i2++;
            }
            if (dp[i3] * 3 == num) {
                i3++;
            }
            if (dp[i5] * 5 == num) {
                i5++;
            }
        }
        return dp[n - 1];
    }


}
