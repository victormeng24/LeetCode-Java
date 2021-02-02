/**
 * Leetcode - bitwise_and_of_numbers_range
 */
package com.victormeng.leetcode.bitwise_and_of_numbers_range;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

/** 
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution1 implements Solution {

    public int rangeBitwiseAnd(int m, int n) {
        int mask = 1 << 30;
        int ret = 0;
        while(mask != 0 && ((m & mask) == (n & mask))) {
            ret += (m & mask);
            mask >>= 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println((1 << 30));
    }

}
