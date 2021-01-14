/**
 * Leetcode - sqrtx
 */
package com.victormeng.leetcode.sqrtx;

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

    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int low = 0, high = x / 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long tar = (long) mid * mid;
            if (tar == x) {
                return mid;
            } else if (tar < x) {
                long add1Tar = (long) (mid + 1) * (mid + 1);
                if (add1Tar > x) {
                    return mid;
                }
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
