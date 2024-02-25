package dynamicprogramming

class CoinChangeII {

    fun change(amount: Int, coins: IntArray): Int {

        val memo = Array(301) { IntArray(5001) { -1 } }
        return helper(0, amount, coins, memo)
    }

    fun helper(i: Int, amount: Int, coins: IntArray, memo: Array<IntArray>): Int {

        if (amount == 0) {
            return 1
        }

        if (i >= coins.size) {
            return 0
        }

        if (memo[i][amount] != -1) {
            return memo[i][amount]
        }

        if (coins[i] > amount) {
            return helper(i + 1, amount, coins, memo)
        }

        val take = helper(i, amount - coins[i], coins, memo)
        val skip = helper(i + 1, amount, coins, memo)

        memo[i][amount] = take + skip
        return memo[i][amount]
    }
}