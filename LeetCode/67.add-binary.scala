/*
 * @lc app=leetcode id=67 lang=scala
 *
 * [67] Add Binary
 */

// @lc code=start
object Solution {
  def addBinary(a: String, b: String): String = {
    val a_len = a.length
    val b_len = b.length
    if (b_len > a_len) return addBinary(b,a)
    var result = List.empty[Int]
    var carry = 0
    
    for (i <- 0 until a_len) {
      val b_bit = if (i < b_len) b(b_len-i-1).asDigit else 0
      val sum = a(a_len-i-1).asDigit + b_bit + carry
      result = if (sum%2 == 0) 0 :: result else 1 :: result
      carry = if (sum < 2) 0 else 1
    }
    if (carry == 1) result = 1 :: result
    result.mkString
  }
}
// @lc code=end

