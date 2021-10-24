/*
 * @lc app=leetcode id=21 lang=scala
 *
 * [21] Merge Two Sorted Lists
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
    def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
        if (l1 != null && l2 != null) {
            if (l1.x < l2.x) ListNode(l1.x,mergeTwoLists(l1.next,l2))
            else ListNode(l2.x,mergeTwoLists(l1,l2.next))
        } 
        else {if (l1 == null) l2 else l1}
    }
}
// @lc code=end

