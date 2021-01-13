/**
 * Leetcode - combinations
 */
package com.victormeng.leetcode.combinations;

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

    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        tmpList = new ArrayList<>();
        if (n < k) {
            return result;
        }
        dfs(1, k, n);
        return result;
    }

    public void dfs(int index, int cnt, int n) {
        if (cnt == 0) {
            result.add(new ArrayList<>(tmpList));
            return;
        }
        for (int i = index; i <= n; i++) {
            tmpList.add(i);
            dfs(i + 1, cnt - 1, n);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
