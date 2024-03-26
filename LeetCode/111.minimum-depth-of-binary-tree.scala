/*
 * @lc app=leetcode id=111 lang=scala
 *
 * [111] Minimum Depth of Binary Tree
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
    def minDepth(root: TreeNode): Int = {
        def minHelper(root: TreeNode, sum: Int): Int = root match {
            case node if node.left == null && node.right == null => sum
            case node if node.left == null => minHelper(node.right, sum+1)
            case node if node.right == null => minHelper(node.left, sum+1)
            case node => scala.math.min(minHelper(node.left,sum+1), minHelper(node.right,sum+1))
        }
        if (root == null) 0
        else minHelper(root, 1)
    }
}
// @lc code=end