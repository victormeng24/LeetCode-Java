/**
 * Leetcode - day_of_year
 */
package com.victormeng.leetcode.day_of_year;
import java.util.*;
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

    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0,4));
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8));
        int[] monthArray = {31,28,31,30,31,30,31,31,30,31,30,31};
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            monthArray[1] = 29;
        }
        int sum = 0;
        for (int i = 0; i < month - 1; i++) {
            sum += monthArray[i];
        }
        sum += day;
        return sum;
    }

}
