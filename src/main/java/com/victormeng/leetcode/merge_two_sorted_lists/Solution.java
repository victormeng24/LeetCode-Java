/**
 * Leetcode - merge_two_sorted_lists
 */
package com.victormeng.leetcode.merge_two_sorted_lists;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

interface Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2);
    // use this Object to print the log (call from slf4j facade)
    static Logger log = LoggerFactory.getLogger(Solution.class);
    
}
