/**
 * Leetcode - print_in_orders
 */
package com.victormeng.leetcode.print_in_orders;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.SynchronousQueue;

import com.ciaoshen.leetcode.util.*;

/** 
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution1 implements Solution {

    

}

class Foo {

    BlockingQueue blockingQueue1;
    BlockingQueue blockingQueue2;

    public Foo() {
        blockingQueue1 = new SynchronousQueue();
        blockingQueue2 = new SynchronousQueue();
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        blockingQueue1.put("Go");
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        blockingQueue1.take();
        printSecond.run();
        blockingQueue2.put("Go");
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        blockingQueue2.take();
        printThird.run();
    }
}
