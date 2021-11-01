/*
 * @lc app=leetcode id=88 lang=scala
 *
 * [88] Merge Sorted Array
 */

// @lc code=start
object Solution {
    def merge(nums1: Array[Int], m: Int, nums2: Array[Int], n: Int): Unit = {
        val result = scala.collection.mutable.ArrayBuffer[Int]()
        var p1 = 0
        var p2 = 0
        while (p1 < m) {
            if (p2 == n || nums1(p1) < nums2(p2)) {
                result += nums1(p1)
                p1 += 1
            }
            else {
                result += nums2(p2)
                p2 += 1
            }
        }
        for (i <- p2 until n) result += nums2(i)
        for (k <- 0 until m+n) nums1(k) = result(k)
    }
}
// @lc code=end

