/*
 * @lc app=leetcode id=104 lang=scala
 *
 * [104] Maximum Depth of Binary Tree
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
    def maxDepth(root: TreeNode): Int = {
        def depth(node: TreeNode, count: Int): Int = {
            if (node == null) count
            else depth(node.left,count+1) max depth(node.right,count+1)
        }
        depth(root,0)
    }
}
// @lc code=end

