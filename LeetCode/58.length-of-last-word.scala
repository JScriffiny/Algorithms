/*
 * @lc app=leetcode id=58 lang=scala
 *
 * [58] Length of Last Word
 */

// @lc code=start
object Solution {
  def lengthOfLastWord(s: String): Int = {
    var count = 0
    var offset = s.length-1
    while (offset >= 0 && s(offset) == ' ') offset -= 1
    for (i <- offset to 0 by -1) if (s(i) != ' ') count += 1 else return count
    count
  }
}
// @lc code=end

