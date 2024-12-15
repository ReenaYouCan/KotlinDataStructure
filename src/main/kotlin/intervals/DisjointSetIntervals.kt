package intervals

import java.util.Arrays

class DisjointSetIntervals {
    val intervalSet = sortedSetOf<Int>()

    fun addNum(value: Int) {
        intervalSet.add(value)
    }

    fun getIntervals(): Array<IntArray> {
        val nums = intervalSet.toIntArray()

        val result = mutableListOf<IntArray>() // what will the size of array here they are not dynamic
        val n = nums.size
        var left: Int
        var i = 0
        while (i < n) {
            // if nums are consecutive

            left = nums[i]
            while (i+1 < n && nums[i] + 1 == nums[i + 1]) {
                i++
            }
            result.add(intArrayOf(left, nums[i]))
            i++
        }

        return result.toTypedArray()
    }

}