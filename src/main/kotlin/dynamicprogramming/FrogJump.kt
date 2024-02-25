package dynamicprogramming


class FrogJump {
    internal class Solution {
        var mark = HashMap<Int, Int>()
        var dp = Array(2001) { BooleanArray(2001) }
        fun canCross(stones: IntArray): Boolean {
            val n = stones.size
            // Mark stones in the map to identify if such stone exists or not.
            for (i in 0 until n) {
                mark[stones[i]] = i
            }
            dp[0][0] = true
            for (index in 0 until n) {
                for (prevJump in 0..n) {
                    // If stone exists, mark the value with position and jump as 1.
                    if (dp[index][prevJump]) {
                        if (mark.containsKey(stones[index] + prevJump)) {
                            dp[mark[stones[index] + prevJump]!!][prevJump] = true
                        }
                        if (mark.containsKey(stones[index] + prevJump + 1)) {
                            dp[mark[stones[index] + prevJump + 1]!!][prevJump + 1] = true
                        }
                        if (mark.containsKey(stones[index] + prevJump - 1)) {
                            dp[mark[stones[index] + prevJump - 1]!!][prevJump - 1] = true
                        }
                    }
                }
            }

            // If any value with index as n - 1 is true, return true.
            for (index in 0..n) {
                if (dp[n - 1][index]) {
                    return true
                }
            }
            return false
        }
    }
}