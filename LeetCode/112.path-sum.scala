/*
 * @lc app=leetcode id=112 lang=scala
 *
 * [112] Path Sum
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
    def hasPathSum(root: TreeNode, targetSum: Int): Boolean = {
        if (root == null) false
        else if (root.left == null && root.right == null && targetSum-root.value == 0) true
        else hasPathSum(root.left, targetSum-root.value) || hasPathSum(root.right, targetSum-root.value)
    }
}
// @lc code=end

