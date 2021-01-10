package com.victormeng.leetcode.min_stack;

import java.util.Stack;

public class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> s1;
    Stack<Integer> minStack;

    public MinStack() {
        s1 = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        int x = s1.pop();
        if (x == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
