package dynamicprogramming

import java.util.*


// Linear Search
class MaximumNumberOfEventsThatCanBeAttended {
    fun maxValue(events: Array<IntArray>, k: Int): Int {
        Arrays.sort(events) { a: IntArray, b: IntArray -> a[0] - b[0] }
        // Memoize
        val dp = Array(events.size + 1) { IntArray(k + 1) { -1 } }
        return helper(events, 0, k, events.size, dp)
    }

    fun helper(events: Array<IntArray>, index: Int, k: Int, size: Int, dp: Array<IntArray>): Int {
        if (index >= size || k <= 0) {
            return 0
        }

        if (dp[index][k] != -1)
            return dp[index][k]

        val skip = helper(events, index + 1, k, size, dp)

        var nextIndex: Int = index + 1
        while (nextIndex < size) {
            if (events[nextIndex][0] > events[index][1]) {
                break
            }
            nextIndex++
        }
        val take = events[index][2] + helper(events, nextIndex, k - 1, size, dp)
        dp[index][k] = Math.max(skip, take)
        return dp[index][k]
    }
}