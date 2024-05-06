package intervals

import java.util.Arrays
import java.util.LinkedList

fun main() {
    val mergeIntervals = MergeIntervals()
    println(
        Arrays.deepToString(
            mergeIntervals.merge(arrayOf(intArrayOf(1, 3), intArrayOf(2, 5), intArrayOf(8, 10), intArrayOf(15, 18)))
        )
    )

    println(
        Arrays.deepToString(
            mergeIntervals.merge(arrayOf(intArrayOf(1, 4), intArrayOf(4, 5)))
        )
    )
}

// Revise the properties of DoubleEnded Queue and LinkedList
class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {

        intervals.sortBy { it[0] }
        // Sort 2D Array

        val result = LinkedList<IntArray>()

        for (i in intervals.indices) { // More concise way
            val curr = intervals[i]
            if (result.isEmpty()) {
                // add curr to LinkedList
                result.add(curr)
            } else {
                val last = result.last
                if (curr[0] <= last[1]) {
                    // merge two intervals
                    val start = Math.min(curr[0], last[0])
                    val end = Math.max(curr[1], curr[1])
                    result.removeLast()
                    result.addLast(intArrayOf(start, end))
                } else {
                    result.addLast(curr)
                }
            }
        }

        return result.toTypedArray()
    }
}