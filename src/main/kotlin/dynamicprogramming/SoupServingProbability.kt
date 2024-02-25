package dynamicprogramming

class SoupServingProbability {

    /**
     * n ml
     *
     * Soup A and B
     *
     *
     *
     */


    fun soupServings(n: Int): Double {
        val serves = arrayOf(intArrayOf(100, 0), intArrayOf(75, 25), intArrayOf(50, 50), intArrayOf(25, 75))
        val memo = Array(n + 1) { DoubleArray(n + 1) { -1.0 } }
        return helper(n, n, serves, memo)
    }

    fun helper(A: Int, B: Int, serves: Array<IntArray>, memo: Array<DoubleArray>): Double {

        if (A <= 0 && B <= 0)
            return 0.50

        if (A <= 0)
            return 1.0

        if (B <= 0)
            return 0.0

        if (memo[A][B] != -1.0)
            return memo[A][B]

        var probability = 0.0

        for (serve in serves) {
            val serveA = serve[0]
            val serveB = serve[1]
            probability += helper(A - serveA, B - serveB, serves, memo)
        }


        memo[A][B] = probability * 0.25
        return probability * 0.25
    }
}