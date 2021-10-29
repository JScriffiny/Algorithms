/*
 * @lc app=leetcode id=69 lang=scala
 *
 * [69] Sqrt(x)
 */

// @lc code=start
object Solution {
  def mySqrt(x: Int): Int = {
    var lo = 1
    var hi = x
    while (lo <= hi) {
      val mid = (lo+hi)/2
      if (mid > x/mid) hi = mid-1
      else lo = mid+1
    }
    lo-1
  }
}
// @lc code=end

