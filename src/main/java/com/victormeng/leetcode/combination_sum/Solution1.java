/**
 * Leetcode - combination_sum
 */
package com.victormeng.leetcode.combination_sum;

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
    List<Integer> tmpList;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        tmpList = new ArrayList<>();
        dfs(0, candidates, target);
        return result;
    }

    public void dfs(int index, int[] candidates, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(tmpList));
            return;
        }
        if (index >= candidates.length) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                continue;
            }
            tmpList.add(candidates[i]);
            dfs(i, candidates, target - candidates[i]);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
