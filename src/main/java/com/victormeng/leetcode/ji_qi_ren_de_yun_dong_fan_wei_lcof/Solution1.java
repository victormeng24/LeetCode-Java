/**
 * Leetcode - ji_qi_ren_de_yun_dong_fan_wei_lcof
 */
package com.victormeng.leetcode.ji_qi_ren_de_yun_dong_fan_wei_lcof;

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
    int ans = 0;

    public int movingCount(int m, int n, int k) {
        if (m == 0 || n == 0) {
            return 0;
        }
        ans = 0;
        search(new boolean[m][n], 0, 0, k);
        return ans;
    }

    public void search(boolean[][] visited, int i, int j, int k) {
        if (i < 0 || i >= visited.length || j < 0 || j >= visited[0].length) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if (getDightSum(i) + getDightSum(j) <= k) {
            ans++;
            search(visited, i + 1, j, k);
            search(visited, i - 1, j, k);
            search(visited, i, j + 1, k);
            search(visited, i, j - 1, k);
        }
    }

    public int getDightSum(int x) {
        int ret = 0;
        while (x != 0) {
            ret += x % 10;
            x /= 10;
        }
        return ret;
    }
}
