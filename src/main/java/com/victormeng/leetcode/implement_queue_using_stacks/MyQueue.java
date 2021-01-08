package com.victormeng.leetcode.implement_queue_using_stacks;

import java.util.Stack;

public class MyQueue {
    /**
     * Initialize your data structure here.
     */
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        stack1.push(x);
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    /**
     * Get the top element.
     */
    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
