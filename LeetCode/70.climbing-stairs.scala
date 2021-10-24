/*
 * @lc app=leetcode id=70 lang=scala
 *
 * [70] Climbing Stairs
 */

// @lc code=start
object Solution {
  def climbStairs(n: Int): Int = {
    if (n < 3) n
    else {
      val climb = Array.fill(n+2)(0)
      for (stair <- n to 0 by -1) climb(stair) = {
        if (stair >= n-1) 1
        else if (stair >= n-2) 2
        else climb(stair+1) + climb(stair+2)
      }
      climb(0)
    }
  }
}
// @lc code=end

// Memoization
// val memo = Array.fill(n+2)(-99)
// def climb(stair: Int): Int = {
//   if (stair == n-1) 1
//   else if (stair == n-2) 2
//   else {
//     if (memo(stair) == -99) memo(stair) = climb(stair+1)+climb(stair+2)
//     memo(stair)
//   }
// }
// climb(0)