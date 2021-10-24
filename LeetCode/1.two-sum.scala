/*
 * @lc app=leetcode id=1 lang=scala
 *
 * [1] Two Sum
 */

// @lc code=start
object Solution {
    def twoSum(nums: Array[Int], target: Int): Array[Int] = {
        val diffs = scala.collection.mutable.HashSet[Int]()
        val s_nums = nums.sorted
        
        // Check for duplicates and zero
        for (i <- 0 until nums.length) {
            if (i > 0 && s_nums(i-1)+s_nums(i) == target) {
                var result = List[Int]()
                for (j <- 0 until nums.length) if (Set(s_nums(i-1),s_nums(i)).contains(nums(j))) result = j :: result
                return result.toArray
            }
        }
        
        for (i <- 0 until nums.length) {
            val diff = target-nums(i)
            if (diff != target/2) diffs += diff
        }
        var result = List[Int]()
        for (i <- 0 until nums.length) if (diffs.contains(nums(i))) result = i :: result
        return result.toArray
    }
}
// @lc code=end

