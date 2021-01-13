/**
 * Leetcode - subsets
 */
package com.victormeng.leetcode.subsets;

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

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        tmpList = new ArrayList<>();
        dfs(0, nums);
        return result;
    }

    public void dfs(int index, int[] nums) {

        result.add(new ArrayList<>(tmpList));

        for (int i = index; i < nums.length; i++) {
            tmpList.add(nums[i]);
            dfs(i + 1, nums);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
