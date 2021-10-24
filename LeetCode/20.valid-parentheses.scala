/*
 * @lc app=leetcode id=20 lang=scala
 *
 * [20] Valid Parentheses
 */

// @lc code=start
object Solution {
    def isValid(s: String): Boolean = {
        val ch_map = scala.collection.immutable.Map[Char, Char](
            '(' -> ')',
            '[' -> ']',
            '{' -> '}'
        )
        val stack = scala.collection.mutable.Stack[Char]()
        for (ch <- s) {
            if (ch_map.contains(ch)) stack.push(ch)
            else {
                try {if (ch != ch_map(stack.pop)) return false}
                catch {case e: NoSuchElementException => return false}
            }
        }
        stack.isEmpty
    }
}
// @lc code=end

