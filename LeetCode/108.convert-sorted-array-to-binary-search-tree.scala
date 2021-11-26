/*
 * @lc app=leetcode id=108 lang=scala
 *
 * [108] Convert Sorted Array to Binary Search Tree
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
    def sortedArrayToBST(nums: Array[Int]): TreeNode = {
        def bst(lo: Int, hi: Int): TreeNode = {
            if (hi < lo) null
            else if (lo == hi) TreeNode(nums(lo),null,null)
            else {
                val mid = (lo+hi)/2
                TreeNode(nums(mid),bst(lo,mid-1),bst(mid+1,hi))
            }
        }
        bst(0,nums.length-1)
    }
}
// @lc code=end

