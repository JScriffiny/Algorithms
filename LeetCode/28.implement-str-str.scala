/*
 * @lc app=leetcode id=28 lang=scala
 *
 * [28] Implement strStr()
 */

// @lc code=start
object Solution {
  def strStr(haystack: String, needle: String): Int = {
    val len_hay = haystack.length
    val len_needle = needle.length
    var ptr = 0
    while (ptr <= len_hay-len_needle) {
      var i = 0
      while (ptr+i < len_hay && i < len_needle && haystack(ptr+i) == needle(i)) i += 1
      if (i == len_needle) return ptr
      else ptr += 1
    }
    -1
  }
}
// @lc code=end

