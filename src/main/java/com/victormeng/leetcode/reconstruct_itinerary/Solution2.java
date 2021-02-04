/**
 * Leetcode - reconstruct_itinerary
 */
package com.victormeng.leetcode.reconstruct_itinerary;

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
class Solution2 implements Solution {

    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        Map<String, Queue<String>> srcToDstMap = new HashMap<>();
        for (List<String> schedule : tickets) {
            String src = schedule.get(0);
            String dst = schedule.get(1);
            if (!srcToDstMap.containsKey(src)) {
                srcToDstMap.put(src, new PriorityQueue<>());
            }
            srcToDstMap.get(src).offer(dst);
        }
        dfs(result, srcToDstMap, "JFK");
        Collections.reverse(result);
        return result;
    }

    public void dfs(List<String> result,
                    Map<String, Queue<String>> srcToDstMap, String currentCity) {
        while (srcToDstMap.containsKey(currentCity) && srcToDstMap.get(currentCity).size() > 0) {
            String city = srcToDstMap.get(currentCity).poll();
            dfs(result, srcToDstMap, city);
        }
        result.add(currentCity);
    }

}
