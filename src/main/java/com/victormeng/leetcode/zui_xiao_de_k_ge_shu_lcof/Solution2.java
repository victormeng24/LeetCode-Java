/**
 * Leetcode - zui_xiao_de_k_ge_shu_lcof
 */
package com.victormeng.leetcode.zui_xiao_de_k_ge_shu_lcof;

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
class Solution2 implements Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int[] ret = new int[k];
        for (int num : arr) {
            queue.offer(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            ret[i] = queue.poll();
        }
        return ret;
    }
}
