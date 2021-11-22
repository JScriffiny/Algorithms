/*
 * @lc app=leetcode id=100 lang=scala
 *
 * [100] Same Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
    def isSameTree(p: TreeNode, q: TreeNode): Boolean = {
        if (p == null && q == null) true
        else if (p == null || q == null) false
        else if (p.value == q.value) isSameTree(p.left,q.left) && isSameTree(p.right,q.right)
        else false
    }
}
// @lc code=end

