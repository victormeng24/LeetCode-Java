package com.victormeng.leetcode.flattern_nested_iterator;

import com.ciaoshen.leetcode.util.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class NestedIterator implements Iterator<Integer> {
    Deque<NestedInteger> stack = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; --i) {
            stack.offerFirst(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pollFirst().getInteger();
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        } else {
            if (!stack.peekFirst().isInteger()) {
                List<NestedInteger> ni = stack.pollFirst().getList();
                for (int i = ni.size() - 1; i >= 0; --i) {
                    stack.offerFirst(ni.get(i));
                }
                return hasNext();
            } else {
                return true;
            }
        }
    }
}
