package greedy

//https://leetcode.com/problems/candy/description/?envType=daily-question&envId=2023-09-13

class Candy {
    fun candy(ratings: IntArray): Int {
        // Take two arrays prefixSum
        // LeftToRight
        // RightToLeft
        var result = 0
        val n = ratings.size

        val leftToRight = IntArray(n) { 1 }
        val rightToLeft = IntArray(n) { 1 }

        for (i in 1 until n) {
            // Left to right
            if (ratings[i] > ratings[i - 1]) {
                leftToRight[i] = Math.max(leftToRight[i], leftToRight[i - 1] + 1)
            }
        }

        for (i in n - 2 downTo 0) {
            if (ratings[i] > ratings[i + 1]) {
                rightToLeft[i] = Math.max(rightToLeft[i], rightToLeft[i + 1] + 1)
            }
        }

        for (i in 0 until n) {
            result += Math.max(leftToRight[i], rightToLeft[i])
        }
        return result
    }
}