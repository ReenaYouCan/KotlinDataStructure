package intervals

class MeetingRooms {


    fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
        intervals.sortBy { it[0] }

        var prev = intervals[0]

        for (i in 1 until intervals.size) {
            val curr = intervals[i]
            if (prev[1] <= curr[0])
                return false

            prev = curr
        }


        return true
    }
}