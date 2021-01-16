/**
 * Leetcode - gas_station
 */
package com.victormeng.leetcode.gas_station;

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

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int left = 0;
        int pos = 0;
        for (int i = 0; i < gas.length; i++) {
            left += gas[i] - cost[i];
            totalGas += gas[i];
            totalCost += cost[i];
            if (left < 0) {
                pos = i + 1;
                left = 0;
            }
        }
        if (totalGas < totalCost) {
            return -1;
        }
        return pos;
    }

}
