package binarysearch

fun main(args: Array<String>) {
    val minimizeMaximumDifferencePairs = MinimizeMaximumDifferencePairs()
}

class MinimizeMaximumDifferencePairs {
    var n: Int = 0
    private fun isValid(nums: IntArray, mid: Int, p: Int): Boolean {
        var j = 0
        var countPairs = 0
        while (j < n - 1) {
            if (Math.abs(nums[j + 1] - nums[j]) <= mid) {
                countPairs++
                j += 2
            } else {
                j++
            }
        }

        return countPairs >= p
    }

    fun minimizeMax(nums: IntArray, p: Int): Int {
        nums.sort()
        n = nums.size

        var left = 0
        var right = nums[n - 1] - nums[0]

        var result = Int.MAX_VALUE
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (isValid(nums, mid, p)) {
                result = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return result
    }
}