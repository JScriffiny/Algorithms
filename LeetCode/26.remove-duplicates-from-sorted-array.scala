/*
 * @lc app=leetcode id=26 lang=scala
 *
 * [26] Remove Duplicates from Sorted Array
 */

// @lc code=start
object Solution {
  def removeDuplicates(nums: Array[Int]): Int = {
    val len = nums.length
    if (len < 2) len
    else {
      var k = len
      var i = 0
      var dups = 1
      while (i+dups < len) {
        while (i+dups < len && nums(i) == nums(i+dups)) {
          dups += 1
          k -= 1
        }
        if (i+dups < len) nums(i+1) = nums(i+dups)
        i += 1
      }
      k
    }
  }
}
// @lc code=end

