/**
 * Leetcode - number_of_islands
 */
package com.victormeng.leetcode.number_of_islands;
import java.util.*;
import com.ciaoshen.leetcode.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

interface Solution {

    // use this Object to print the log (call from slf4j facade)
    static Logger log = LoggerFactory.getLogger(Solution.class);

    int numIslands(char[][] grid);
}
