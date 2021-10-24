/*
 * @lc app=leetcode id=35 lang=scala
 *
 * [35] Search Insert Position
 */

// @lc code=start
object Solution {
  def searchInsert(nums: Array[Int], target: Int): Int = {
    var lo = 0
    var hi = nums.length-1
    var i = 0
    while (lo < hi) {
      val mid = (lo+hi)/2
      if (nums(mid) > target) hi = mid
      else if (nums(mid) < target) lo = mid+1
      else return mid
    }
    if (nums(lo) < target) lo+1 else lo
  }
}
// @lc code=end

