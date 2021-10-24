/*
 * @lc app=leetcode id=27 lang=scala
 *
 * [27] Remove Element
 */

// @lc code=start
object Solution {
  def removeElement(nums: Array[Int], `val`: Int): Int = {
    val len = nums.length
    var k = 0
    var i = 0
    var offset = 0
    while (i+offset < len) {
      while (i+offset < len && nums(i+offset) == `val`) offset += 1
      if (i+offset < len && nums(i+offset) != `val`) {
        nums(i) = nums(i+offset)
        k += 1
      }
      i += 1
    }
    k
  }
}
// @lc code=end

