package sorting

import java.util.*

fun main() {

    val largestPositive = LargestPositive()
    println(largestPositive.findMaxK(intArrayOf(-1, 2, -3, 3)))
}

class LargestPositive {


    fun findMaxK(nums: IntArray): Int {
        val uSet = mutableSetOf<Int>() // Store -ve nums
        for (i in 0 until nums.size) {
            if (nums[i] < 0) {
                uSet.add(nums[i])
            }
        }

        Arrays.sort(nums)

        for (i in nums.size - 1 downTo 0) {
            if (uSet.contains(-nums[i])) {
                return nums[i]
            }
        }
        return -1
    }
}