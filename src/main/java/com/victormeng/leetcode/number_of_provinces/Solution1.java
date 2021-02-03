/**
 * Leetcode - number_of_provinces
 */
package com.victormeng.leetcode.number_of_provinces;

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

    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> list = new ArrayList<>();
        int n = isConnected.length;
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cnt++;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int city = queue.poll();
                    for (int edge : list.get(city)) {
                        if (!visited[edge]) {
                            queue.offer(edge);
                            visited[edge] = true;
                        }
                    }
                }
            }
        }
        return cnt;
    }

}
