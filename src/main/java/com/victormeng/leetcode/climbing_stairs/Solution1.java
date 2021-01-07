/**
 * Leetcode - climbing_stairs
 */
package com.victormeng.leetcode.climbing_stairs;

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

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int pre = 1, nxt = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = pre + nxt;
            pre = nxt;
            nxt = tmp;
        }
        return nxt;
    }

}
