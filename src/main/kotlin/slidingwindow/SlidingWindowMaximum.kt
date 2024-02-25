package slidingwindow

import java.util.*
import kotlin.collections.ArrayDeque
import kotlin.collections.ArrayList
import kotlin.collections.MutableList


/**
 * 239. Sliding Window Maximum
 * Hard
 * 16.7K
 * 560
 * company
 * Amazon
 * company
 * Microsoft
 * company
 * Uber
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
class SlidingWindowMaximum {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val dq: Deque<Int> = LinkedList()
        val res: MutableList<Int> = ArrayList()
        for (i in 0 until k) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast()
            }
            dq.offerLast(i)
        }
        res.add(nums[dq.peekFirst()])
        for (i in k until nums.size) {
            if (dq.peekFirst() == i - k) {
                dq.pollFirst()
            }
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast()
            }
            dq.offerLast(i)
            res.add(nums[dq.peekFirst()])
        }
        // Return the result as an array.
        return res.stream().mapToInt { i: Int? -> i!! }.toArray()
    }

    /**
     * 1. When new elements comes nums[i],make space for it (window size can't be greater than k) (Remove  all indexes smaller than i-k element from the from if we exceeds window size)
     * 2. Now, when nums[]
     */
    fun maxSlidingWindowQueue(nums: IntArray, k: Int): IntArray {
        val n = nums.size
        val result = IntArray(n - k + 1)

        val dq: Deque<Int> = LinkedList()

        for (i in 0 until n) {
            while (!dq.isEmpty() && dq.first() <= i - k) {
                dq.pollFirst()
            }
            while (nums[i] > nums[dq.last]) {
                dq.pollLast()
            }
            dq.addLast(nums[i])

            if (i >= k - 1) {
                result[i] = dq.first()
            }
        }
        return result
    }
}