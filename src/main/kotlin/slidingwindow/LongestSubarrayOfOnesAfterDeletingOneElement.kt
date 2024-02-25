package slidingwindow

/**
 * Given a binary array nums, you should delete one element from it.
 *
 * Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,0,1]
 * Output: 3
 * Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.
 * Example 2:
 *
 * Input: nums = [0,1,1,1,0,1,1,0,1]
 *
 * end - start -1
 * 7 - 1 -1
 * Output: 5
 * Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].
 * Example 3:
 *
 * Input: nums = [1,1,1]
 * Output: 2
 */
/**
 *
 */


fun main(args: Array<String>) {
    println(longestSubarray(intArrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1)))
}

fun longestSubarray(nums: IntArray): Int {

    var longestArray = 0
    var start = 0
    var end = 0
    var zeros = 0

    while (start < nums.size && end < nums.size) {

        zeros += if (nums[end] == 0) 1 else 0

        while (zeros > 1) {
            zeros -= if (nums[start] == 0) 1 else 0
            start++
        }


        longestArray = Math.max(longestArray, end - start)
        end++
    }


    return longestArray
}