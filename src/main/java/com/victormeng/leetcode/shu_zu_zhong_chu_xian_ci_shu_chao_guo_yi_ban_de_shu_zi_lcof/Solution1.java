/**
 * Leetcode - shu_zu_zhong_chu_xian_ci_shu_chao_guo_yi_ban_de_shu_zi_lcof
 */
package com.victormeng.leetcode.shu_zu_zhong_chu_xian_ci_shu_chao_guo_yi_ban_de_shu_zi_lcof;
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

    public int majorityElement(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int cnt = 1, ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ret) {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                ret = nums[i];
                cnt = 1;
            }
        }
        cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ret) {
                cnt++;
            }
        }
        return cnt > nums.length / 2 ? ret : -1;
    }

}
