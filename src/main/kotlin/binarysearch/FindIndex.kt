package binarysearch

class FindIndex {
}

internal class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val output = IntArray(2)
        output[0] = -1
        output[1] = -1
        var low = 0
        var high = nums.size - 1
        while (low < high) {
            val mid = low + (high - low) / 2
            if (nums[mid] == target) {
                output[0] = mid

                if (mid + 1 <= high) {
                    if (nums[mid + 1] == target)
                        output[1] = mid + 1
                }

                if(mid-1>=0)
                {
                    if (nums[mid - 1] == target)
                        output[1] = mid - 1
                }
                break
            } else if (nums[mid] > target) {
                high = mid
            } else if (nums[mid] < target) {
                low = mid + 1
            }
        }
        return output.sortedArray()
    }
}