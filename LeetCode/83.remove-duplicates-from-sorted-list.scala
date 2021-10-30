/*
 * @lc app=leetcode id=83 lang=scala
 *
 * [83] Remove Duplicates from Sorted List
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
    def deleteDuplicates(head: ListNode): ListNode = {
        def delete(head: ListNode, prev_x: Int): ListNode = {
            if (head == null) head
            else if (head.x == prev_x) delete(head.next,prev_x)
            else ListNode(head.x,delete(head.next,head.x))
        }
        if (head == null) head
        else ListNode(head.x,delete(head.next,head.x))
    }
}
// @lc code=end

