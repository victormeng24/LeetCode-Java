/**
 * Leetcode - reverse_integer
 */
package com.victormeng.leetcode.reverse_integer;

import java.util.*;

import com.ciaoshen.leetcode.util.*;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 *  示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution1 implements Solution {
    public int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            int mod = x % 10;
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && mod > Integer.MAX_VALUE % 10)) {
                return 0;
            }
            if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && mod < Integer.MIN_VALUE % 10)) {
                return 0;
            }
            ret = ret * 10 + mod;
            x /= 10;
        }
        return ret;
    }
}
