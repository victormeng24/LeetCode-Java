/**
 * Leetcode - course_schedule_ii
 */
package com.victormeng.leetcode.course_schedule_ii;

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

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> outList = new ArrayList<>();
        int[] inCountArr = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            outList.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            outList.get(edge[1]).add(edge[0]);
            inCountArr[edge[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inCountArr.length; i++) {
            if (inCountArr[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        int[] ret = new int[numCourses];
        while (!queue.isEmpty()) {
            int courseNum = queue.poll();
            ret[visited++] = courseNum;
            for (int postCourse : outList.get(courseNum)) {
                inCountArr[postCourse]--;
                if (inCountArr[postCourse] == 0) {
                    queue.offer(postCourse);
                }
            }
        }
        return visited == numCourses ? ret : new int[0];
    }

}
