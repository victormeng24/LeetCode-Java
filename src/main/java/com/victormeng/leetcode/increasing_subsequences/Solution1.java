/**
 * Leetcode - increasing_subsequences
 */
package com.victormeng.leetcode.increasing_subsequences;

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

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        doSearchIncreasingSubsequences(result, 0, nums, new ArrayList<>());
        return result;
    }

    public void doSearchIncreasingSubsequences(List<List<Integer>> result, int index, int[] nums, List<Integer> sequence) {
        if (sequence.size() > 1) {
            result.add(new ArrayList<>(sequence));
        }
        Set<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if ((sequence.size() == 0 || nums[i] >= sequence.get(sequence.size() - 1)) && !set.contains(nums[i])) {
                sequence.add(nums[i]);
                set.add(nums[i]);
                doSearchIncreasingSubsequences(result, i + 1, nums, sequence);
                sequence.remove(sequence.size() - 1);
            }
        }
    }
}
