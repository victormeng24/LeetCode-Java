/**
 * Leetcode - k_closest_points_to_origin
 */
package com.victormeng.leetcode.k_closest_points_to_origin;

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

    public int[][] kClosest(int[][] points, int K) {
        int[][] ret = new int[K][2];
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int o2Distance = o2[0] * o2[0] + o2[1] * o2[1];
                int o1Distance = o1[0] * o1[0] + o1[1] * o1[1];
                return o2Distance - o1Distance;
            }
        });
        for (int i = 0; i < points.length; i++) {
            queue.offer(points[i]);
            if (queue.size() > K) {
                queue.poll();
            }
        }
        int index = 0;
        while(!queue.isEmpty()) {
            int[] arr = queue.poll();
            ret[index][0] = arr[0];
            ret[index][1] = arr[1];
            index++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {
                    1, 3
                },
                {
                    -2, 2
                }
        };
        int[][] ret = new Solution1().kClosest(input, 1);
        System.out.println(ret.length);
        System.out.println(ret[0][0] + " " + ret[0][1]);
    }

}
