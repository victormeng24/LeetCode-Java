/**
 * Leetcode - sort_integers_by_the_number_of_1_bits
 */
package com.victormeng.leetcode.sort_integers_by_the_number_of_1_bits;

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

    public int[] sortByBits(int[] arr) {
        int[] dp = new int[10001];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i >> 1] + (i & 1);
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int num : arr) {
            list.add(num);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (dp[o1] != dp[o2]) {
                    return dp[o1] - dp[o2];
                }
                return o1 - o2;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }


}
