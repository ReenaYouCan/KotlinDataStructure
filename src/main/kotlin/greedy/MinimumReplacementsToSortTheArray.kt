package greedy

//https://leetcode.com/problems/minimum-replacements-to-sort-the-array/
class MinimumReplacementsToSortTheArray {

    fun minimumReplacement(nums: IntArray): Long {
        val n = nums.size
        var operations : Long = 0

        for (i in n - 2 downTo 0) {
            if (nums[i] <= nums[i + 1]) {
                continue
            }

            var parts = nums[i] / nums[i + 1]

            if(nums[i]%nums[i+1]!=0)
                parts+=1

            operations += parts-1

            nums[i] = nums[i]/parts
        }

        return operations
    }
}