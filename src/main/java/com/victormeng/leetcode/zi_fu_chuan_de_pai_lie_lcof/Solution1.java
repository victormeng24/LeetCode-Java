/**
 * Leetcode - zi_fu_chuan_de_pai_lie_lcof
 */
package com.victormeng.leetcode.zi_fu_chuan_de_pai_lie_lcof;

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

    char[] arr;
    List<String> res;

    public String[] permutation(String s) {
        arr = s.toCharArray();
        res = new ArrayList<>();
        dfs(0);
        return res.toArray(new String[0]);
    }

    public void dfs(int index) {
        if (index == arr.length) {
            res.add(String.valueOf(arr));
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                continue;
            }
            set.add(arr[i]);
            swap(arr, i, index);
            dfs(index + 1);
            swap(arr, i, index);
        }
    }

    public void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
