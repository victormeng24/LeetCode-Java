package com.victormeng.leetcode.design_hit_counter;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {
    Queue<Integer> queue;
    int startIndex = -1;    // 五分钟内的第一次敲击的时间戳，-1 表示没有元素

    /** Initialize your data structure here. */
    public HitCounter() {
        queue = new LinkedList<Integer>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        if(startIndex == -1) {  // 当前没有元素，新敲击的作为第一个
            startIndex = timestamp;
        }
        queue.offer(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        // 五分钟的临界值应该是 timestamp - startIndex + 1 == 300
        // 或者队列根本没有元素
        while (timestamp - startIndex >= 300 && !queue.isEmpty()) {
            // timestamp - startIndex >= 300 说明当前队首元素超过了5分钟，删除队首
            queue.poll();
            if(!queue.isEmpty()) {
                // 如果队列不为空，更新 startIndex 为新的队首
                startIndex = queue.peek();
            } else {
                // 如果队列为已经为空，则 startIndex 恢复成初始值
                startIndex = -1;
            }
        }
        return queue.size();
    }
}
