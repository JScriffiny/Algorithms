/*
 * @lc app=leetcode id=101 lang=scala
 *
 * [101] Symmetric Tree
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
    def isSymmetric(root: TreeNode): Boolean = {
        def isSym(leftNode: TreeNode, rightNode: TreeNode): Boolean = {
            if (leftNode == null && rightNode == null) true
            else {
                try {
                    if (leftNode.value == rightNode.value)
                        isSym(leftNode.left,rightNode.right) &&
                        isSym(leftNode.right,rightNode.left)
                    else false
                }
                catch {case e: NullPointerException => false}
            }
        }
        isSym(root.left,root.right)
    }
}
// @lc code=end

