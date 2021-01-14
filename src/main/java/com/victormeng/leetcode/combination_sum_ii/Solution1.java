/**
 * Leetcode - combination_sum_ii
 */
package com.victormeng.leetcode.combination_sum_ii;

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

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result = new ArrayList<>();
        tmpList = new ArrayList<>();
        if (target == 0) {
            return result;
        }
        Arrays.sort(candidates);
        dfs(0, candidates, target);
        return result;
    }

    public void dfs(int index, int[] candidates, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(tmpList));
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            tmpList.add(candidates[i]);
            dfs(i + 1, candidates, target - candidates[i]);
            tmpList.remove(tmpList.size() - 1);
        }
    }

}
