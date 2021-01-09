/**
 * Leetcode - shu_zu_zhong_shu_zi_chu_xian_de_ci_shu_lcof
 */
package com.victormeng.leetcode.shu_zu_zhong_shu_zi_chu_xian_de_ci_shu_lcof;
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

    public int[] singleNumbers(int[] nums) {
        int xOrRet = 0;
        for (int num: nums) {
            xOrRet ^= num;
        }
        int valToSeperate = 1;
        while((xOrRet & valToSeperate) == 0) {
            valToSeperate <<= 1;
        }
        int groupA = 0, groupB = 0;
        for (int num: nums) {
            if ((num & valToSeperate) != 0) {
                groupA ^= num;
            } else {
                groupB ^= num;
            }
        }
        return new int[]{groupA, groupB};
    }
}
