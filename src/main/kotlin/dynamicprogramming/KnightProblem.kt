package dynamicprogramming

class KnightProblem {
    fun knightProbability(n: Int, k: Int, row: Int, column: Int): Double {
        val directions = arrayOf(
            intArrayOf(1, 2), intArrayOf(1, -2),
            intArrayOf(-1, 2), intArrayOf(-1, -2),
            intArrayOf(2, 1), intArrayOf(-2, 1),
            intArrayOf(2, -1), intArrayOf(-2, -1)
        )

        val dp = mutableMapOf<String, Double>()

        return helper(n, row, column, k, directions, dp)
    }

    fun helper(n: Int, r: Int, c: Int, k: Int, directions: Array<IntArray>, dp: MutableMap<String, Double>): Double {

        if (r >= n || r < 0 || c >= n || c < 0)
            return 0.0

        if (k == 0)
            return 1.0

        val key = "${r}_${c}_${k}"
        if (dp.contains(key))
            return dp[key]!!

        var result = 0.0

        for (dir in directions) {
            val nR = r + dir[0]
            val nC = c + dir[1]

            result += helper(n, nR, nC, k - 1, directions, dp)
        }

        dp[key] = result / 8
        return dp[key]!!
    }
}