/**
 * Leetcode - simplify_path
 */
package com.victormeng.leetcode.simplify_path;

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
class Solution2 implements Solution {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while (i < path.length()) {
            if (path.charAt(i) == '/') {
                i++;
                continue;
            }
            String str = "";
            while (i < path.length() && path.charAt(i) != '/') str += path.charAt(i++);
            if (str.equals(".")) continue;
            if (str.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
                else continue;
            } else stack.push(str);
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = "/" + stack.pop() + res;

        }
        return res.length() == 0 ? "/" : res;
    }

}
