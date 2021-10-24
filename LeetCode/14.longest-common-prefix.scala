/*
 * @lc app=leetcode id=14 lang=scala
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
object Solution {
    def longestCommonPrefix(strs: Array[String]): String = {
        var result = strs(0)
        for (s <- strs) {
            var i = 0
            while (i <= s.length && s.slice(0,i) == result.slice(0,i)) i += 1
            result = result.slice(0,i-1)
        }
        result
    }
}
// @lc code=end

