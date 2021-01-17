/**
 * Leetcode - powx_n
 */
package com.victormeng.leetcode.powx_n;

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

    public double fastPow(double x, long n) {
        if (n == 0) return 1.0;
        if (n < 0) return 1.0 / fastPow(x, -n);
        double a = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return a * a;
        } else return a * a * x;
    }

    public double myPow(double x, int n) {
        long N = n;
        return fastPow(x, N);
    }

}
