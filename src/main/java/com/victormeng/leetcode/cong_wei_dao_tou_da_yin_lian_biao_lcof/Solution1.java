/**
 * Leetcode - cong_wei_dao_tou_da_yin_lian_biao_lcof
 */
package com.victormeng.leetcode.cong_wei_dao_tou_da_yin_lian_biao_lcof;

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

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode pointer = head;
        while (pointer != null) {
            stack.push(pointer.val);
            pointer = pointer.next;
        }
        int[] ret = new int[stack.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = stack.pop();
        }
        return ret;
    }

}
