/**
 * Leetcode - minimum_cost_to_connect_sticks
 */
package com.victormeng.leetcode.minimum_cost_to_connect_sticks;

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

    public int connectSticks(int[] sticks) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int stick : sticks) {
            queue.offer(stick);
        }
        int cost = 0;
        while (queue.size() > 1) {
            int min1 = queue.poll();
            int min2 = queue.poll();
            cost += min1 + min2;
            queue.offer(min1 + min2);
        }
        return cost;
    }

}
