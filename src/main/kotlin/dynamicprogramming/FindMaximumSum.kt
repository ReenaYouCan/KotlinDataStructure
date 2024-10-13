package dynamicprogramming

class FindMaximumSum {
    fun maxPoints(points: Array<IntArray>): Long {

        val m = points.size// number of rowa
        val n = points[0].size // number of cols


        var prev = Array<Long>(n){0}

        // Maintain the previvous
        for(col in 0 until n)
        {
            prev[col] = points[0][col].toLong()
        }

        for(row in 1 until m)
        {
            val current = Array<Long>(n){Long.MIN_VALUE}

            for(col in 0 until  n)
            {
                // Current Col + prev[col]
                // curr col = Max(curr[col], prev[col]+points[r][col]-Math.abs())
                for(i in 0 until n)
                {
                    current[col] = Math.max(current[col], prev[i]+points[row][col]-Math.abs(i-col))
                }

            }
            prev = current

        }
        return prev.max()
    }

}