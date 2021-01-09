/**
 * Leetcode - factorial_trailing_zeroes
 */
package com.victormeng.leetcode.factorial_trailing_zeroes;

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

    public int trailingZeroes(int n) {
        int ret = 0;
        while (n != 0) {
            n /= 5;
            ret += n;
        }
        return ret;
    }

}
