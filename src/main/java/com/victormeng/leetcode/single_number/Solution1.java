/**
 * Leetcode - single_number
 */
package com.victormeng.leetcode.single_number;
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

    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int num: nums) {
            ret ^= num;
        }
        return ret;
    }

}
