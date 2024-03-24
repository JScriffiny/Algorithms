/*
 * @lc app=leetcode id=125 lang=scala
 *
 * [125] Valid Palindrome
 */

// @lc code=start
object Solution {
    def isPalindrome(s: String): Boolean = {
        val forwards = s.flatMap(ch => if (ch.isLetter || ch.isDigit) Some(ch.toLower) else None)
        val backwards = forwards.reverse
        forwards.indices.forall(i => forwards(i) == backwards(i))
    }
}
// @lc code=end

