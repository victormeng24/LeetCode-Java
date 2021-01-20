/**
 * Leetcode - top_k_frequent_elements
 */
package com.victormeng.leetcode.top_k_frequent_elements;

import java.util.*;

import com.ciaoshen.leetcode.util.*;
import org.omg.CORBA.INTERNAL;

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

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(new int[]{entry.getKey(), entry.getValue()});
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }

}
