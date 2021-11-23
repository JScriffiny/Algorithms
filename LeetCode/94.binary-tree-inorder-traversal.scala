/*
 * @lc app=leetcode id=94 lang=scala
 *
 * [94] Binary Tree Inorder Traversal
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
    def inorderTraversal(root: TreeNode): List[Int] = {
        if (root == null) List()
        else if (root.left == null && root.right == null) List(root.value)
        else inorderTraversal(root.left) ::: (root.value :: inorderTraversal(root.right))
    }
}
// @lc code=end

