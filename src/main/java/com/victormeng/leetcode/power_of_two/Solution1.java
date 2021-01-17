/**
 * Leetcode - power_of_two
 */
package com.victormeng.leetcode.power_of_two;

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

    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

}
