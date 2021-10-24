/*
 * @lc app=leetcode id=13 lang=scala
 *
 * [13] Roman to Integer
 */

// @lc code=start
object Solution {
    def romanToInt(s: String): Int = {
        val map1 = scala.collection.mutable.Map[String, Int](
            "I" -> 1,
            "V" -> 5,
            "X" -> 10,
            "L" -> 50,
            "C" -> 100,
            "D" -> 500,
            "M" -> 1000
        )
        val map2 = scala.collection.mutable.Map[String, Int](
            "IV" -> 4,
            "IX" -> 9,
            "XL" -> 40,
            "XC" -> 90,
            "CD" -> 400,
            "CM" -> 900
        )
        var result = 0
        var i = 0
        while (i < s.length) {
            if (i < s.length-1 && map2.contains(s(i).toString+s(i+1).toString)) {
                result += map2(s(i).toString+s(i+1).toString)
                i += 1
            } else result += map1(s(i).toString)
            i += 1
        }
        result
    }
}
// @lc code=end

