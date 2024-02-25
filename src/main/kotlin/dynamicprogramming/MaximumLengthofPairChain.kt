package dynamicprogramming

//https://leetcode.com/problems/maximum-length-of-pair-chain/

fun main(args: Array<String>) {

}
class MaximumLengthofPairChain {

    fun findLongestChain(pairs: Array<IntArray>): Int {
        val dp = Array(1001){IntArray(1001){-1}}

        pairs.sortBy { it[0] }
        return helper(-1, 0, pairs,dp)
    }

fun helper(prev: Int, curr: Int, pairs: Array<IntArray>,dp: Array<IntArray>): Int {
    //Base Case
    if (curr >= pairs.size) {
        return 0
    }

    if(dp[prev][curr]!=-1)
    {
        return dp[prev][curr]
    }

    var take = 0
    var skip = 0
    // Take the element

    if (prev == -1 || pairs[prev][1] < pairs[curr][0]) {
        take = 1 + helper(curr, curr + 1, pairs,dp)
    }

    //Skip the element
    skip = helper(prev, curr + 1, pairs,dp)

    //take max between these

    return Math.max(take, skip).also {  dp[prev][curr] = it }
}
}