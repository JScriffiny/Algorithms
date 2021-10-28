/*
 * @lc app=leetcode id=66 lang=scala
 *
 * [66] Plus One
 */

// @lc code=start
object Solution {
  def plusOne(digits: Array[Int]): Array[Int] = {
    var i = digits.length-1
    while (i >= 0 && digits(i) == 9) {
      digits(i) = 0
      i -= 1
    }
    if (i >= 0) {
      digits(i) += 1
      digits
    }
    else 1 +: digits
  }
}
// @lc code=end

