package dynamicprogramming

fun main(args: Array<String>) {
    val extraCharactersInString = ExtraCharactersInString()
    val dictionary = arrayOf("leet", "code", "leetcode")
    val s = "leetscode"
    extraCharactersInString.minExtraChar(s, dictionary)

}

class ExtraCharactersInString {
    fun minExtraChar(s: String, dictionary: Array<String>): Int {
        val dic = dictionary.toHashSet()
        val dp = IntArray(51) { -1 }
        return helper(s, 0, dic, dp)
    }

    fun helper(s: String, idx: Int, dictionary: HashSet<String>, dp: IntArray): Int {
        val n = s.length
        if (idx >= n)
            return 0

        if (dp[idx] != -1)
            return dp[idx]

        var minExtra = Int.MAX_VALUE
        var currMax: String = ""

        for (i in idx until n) {
            currMax += s[i]
            var currExtra = 0
            if (!dictionary.contains(currMax)) {
                currExtra = currMax.length
            }

            val nextExtra = helper(s, i + 1, dictionary, dp)

            val totalExtra = currExtra + nextExtra
            minExtra = Math.min(totalExtra, minExtra)
        }
        dp[idx] = minExtra
        return minExtra.also { dp[idx] = it }
    }
}