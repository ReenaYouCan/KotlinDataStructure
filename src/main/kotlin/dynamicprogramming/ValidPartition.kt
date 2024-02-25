package dynamicprogramming


class ValidPartition {
    internal class Solution {
        var memo: MutableMap<Int, Boolean> = HashMap()

        // Determine if the prefix array nums[0 ~ i] has a valid partition
        fun prefixIsValid(nums: IntArray, i: Int): Boolean {
            if (memo.containsKey(i)) {
                return memo[i]!!
            }
            var ans = false

            // Check 3 possibilities
            if (i > 0 && nums[i] == nums[i - 1]) {
                ans = ans or prefixIsValid(nums, i - 2)
            }
            if (i > 1 && nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2]) {
                ans = ans or prefixIsValid(nums, i - 3)
            }
            if (i > 1 && nums[i] == nums[i - 1] + 1 && nums[i - 1] == nums[i - 2] + 1) {
                ans = ans or prefixIsValid(nums, i - 3)
            }
            memo[i] = ans
            return ans
        }

        fun validPartition(nums: IntArray): Boolean {
            val n = nums.size
            memo[-1] = true
            return prefixIsValid(nums, n - 1)
        }
    }
}