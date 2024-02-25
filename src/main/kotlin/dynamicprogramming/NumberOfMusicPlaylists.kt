package dynamicprogramming

class NumberOfMusicPlaylists {
    internal class Solution {
        fun numMusicPlaylists(n: Int, goal: Int, k: Int): Int {
            val MOD = 1000000007

            // Initialize the DP table
            val dp = Array(goal + 1) { LongArray(n + 1) }
            dp[0][0] = 1
            for (i in 1..goal) {
                for (j in 1..Math.min(i, n)) {
                    // The i-th song is a new song
                    dp[i][j] = dp[i - 1][j - 1] * (n - j + 1) % MOD
                    // The i-th song is a song we have played before
                    if (j > k) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j] * (j - k)) % MOD
                    }
                }
            }
            return dp[goal][n].toInt()
        }
    }
}