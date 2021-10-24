/*
 * @lc app=leetcode id=9 lang=scala
 *
 * [9] Palindrome Number
 */

// @lc code=start
object Solution {
    def isPalindrome(x: Int): Boolean = {
        val str_x = x.toString
        if (str_x(0) == '-') false
        for (i <- 0 until str_x.length/2) if (str_x(i) != str_x(str_x.length-1-i)) return false
        true
    }
}
// @lc code=end

