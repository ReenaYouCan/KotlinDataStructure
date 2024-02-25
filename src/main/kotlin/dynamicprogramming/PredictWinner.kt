package dynamicprogramming

//https://leetcode.com/problems/predict-the-winner/submissions/
class PredictWinner {
    fun PredictTheWinner(nums: IntArray): Boolean {

        val dp = Array(23){IntArray(23){-1}}

        val difference = helper(0,nums.size-1,nums,dp)


        return difference>=0
    }

    fun helper(start:Int,end:Int,nums:IntArray,dp:Array<IntArray>) : Int
    {
        if(start>end)
        {
            return 0
        }

        if(start==end)
        {
            return nums[start]
        }

        if(dp[start][end]!=-1)
        {
            return dp[start][end]
        }

        val takeStart = nums[start] - helper(start+1,end,nums,dp)
        val takeEnd = nums[end] - helper(start,end-1,nums,dp)

        dp[start][end] = Math.max(takeStart,takeEnd)
        return dp[start][end]
    }
}