/**
 * Leetcode - permutations
 */
package com.victormeng.leetcode.permutations;

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

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        dfs(0, nums);
        return result;
    }

    public void dfs(int index, int[] nums) {
        if (index == nums.length) {
            List<Integer> subResult = new ArrayList<>();
            for (int num : nums) {
                subResult.add(num);
            }
            result.add(subResult);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            dfs(index + 1, nums);
            swap(nums, i, index);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
