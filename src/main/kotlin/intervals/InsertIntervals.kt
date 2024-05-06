package intervals

//https://leetcode.com/problems/insert-interval/?envType=study-plan-v2&envId=top-interview-150
class InsertIntervals {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val n = intervals.size
        var i = 0

        val result = mutableListOf<IntArray>()
        // Case 1 No overlaps curr.end < new.start

        while(i<n && intervals[i][1]<newInterval[0])
        {
            result.add(intervals[i])
            i++
        }

        //Case 2 Overlapping and merging intervals new.end > curr.start
        while(i<n && newInterval[1]>=intervals[i][0])
        {
            newInterval[0] = Math.min(newInterval[0],intervals[i][0])
            newInterval[1] = Math.max(newInterval[1],intervals[i][1])
            i++
        }

        result.add(newInterval)

        //Case 3 No overlap after merging interval
        while(i<n)
        {
            result.add(intervals[i])
            i++
        }

        return result.toTypedArray()
    }
}