/**
 * Leetcode - unique_number_of_occurences
 */
package com.victormeng.leetcode.unique_number_of_occurences;

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

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (int count : map.values()) {
            if (!set.add(count)) {
                return false;
            }
        }
        return true;
    }

}
