package com.victormeng.leetcode.insert_delete_getrandom_o1;

import java.util.*;

public class RandomizedSet {
    /**
     * Initialize your data structure here.
     */
    List<Integer> list;
    Map<Integer, Integer> dict;

    public RandomizedSet() {
        list = new ArrayList<>();
        dict = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (dict.containsKey(val)) {
            return false;
        }
        dict.put(val, list.size());
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if(!dict.containsKey(val)) {
            return false;
        }
        int indices = dict.get(val);
        int lastIndicesValue = list.get(list.size() - 1);
        dict.put(lastIndicesValue, indices);
        dict.remove(val);
        list.set(indices, lastIndicesValue);
        list.remove(list.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}
