/**
 * Leetcode - sort_an_array
 */
package com.victormeng.leetcode.sort_an_array;
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

    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }

}
