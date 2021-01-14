/**
 * Leetcode - group_anagrams
 */
package com.victormeng.leetcode.group_anagrams;

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

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        for (List<String> list : map.values()) {
            result.add(list);
        }
        return result;
    }
}
