/**
 * Leetcode - combination_sum_iii
 */
package com.victormeng.leetcode.combination_sum_iii;

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

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum3(int k, int n) {
        result = new ArrayList<>();
        search(new ArrayList<>(), 1, n, k);
        return result;
    }

    public void search(List<Integer> list, int start, int target, int k) {
        if (k < 0) {
            return;
        }
        if (k == 0 && target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (i <= target) {
                list.add(i);
                search(list, i + 1, target - i, k - 1);
                list.remove(list.size() - 1);
            }
        }
    }

}
