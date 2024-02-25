package backtracking

/**
 * Combinations
 * Medium
 * 6.2K
 * 190
 * Companies
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 *
 * You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4, k = 2
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 * Example 2:
 *
 * Input: n = 1, k = 1
 * Output: [[1]]
 * Explanation: There is 1 choose 1 = 1 total combination.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 20
 * 1 <= k <= n
 */
fun main(args: Array<String>) {
    val combination = Combinations()
    val output = combination.combine(10, 4)
    println(output)

}

class Combinations {

    fun combine(n: Int, k: Int): MutableList<List<Int>> {
        val ans = mutableListOf<List<Int>>()
        return helperReturnList(n, k, 1, mutableListOf())

    }


    // Passing answer in method argument
    fun helper(n: Int, k: Int, startNum: Int, curr: MutableList<Int>, answer: MutableList<List<Int>>) {
        if (curr.size == k) {
            answer.add(ArrayList(curr)) // Need to create copy of elements lets check what happens here
            return
        }

        for (i in startNum..n) {
            curr.add(i)
            helper(n, k, i + 1, curr, answer)
            curr.removeAt(curr.size - 1)
        }
    }

    // Returning answer
    fun helperReturnList(
        n: Int,
        k: Int,
        startNum: Int,
        curr: MutableList<Int>
    ): MutableList<List<Int>> {
        if (curr.size == k) {
            val ans = mutableListOf<List<Int>>()
            ans.add(ArrayList(curr)) // Need to create copy of elements lets check what happens here
            return ans
        }

        val finalAns = mutableListOf<List<Int>>()

        for (i in startNum..n) {
            curr.add(i)
            finalAns.addAll(helperReturnList(n, k, i + 1, curr))
            curr.removeAt(curr.size - 1)
        }
        return finalAns
    }

    //Returning count
    fun helperReturnCount(
        n: Int,
        k: Int,
        startNum: Int,
        curr: MutableList<Int>
    ): Int {
        if (curr.size == k) {
            return 1
        }

        var finalAns = 0

        for (i in startNum..n) {
            curr.add(i)
            finalAns += helperReturnCount(n, k, i + 1, curr)
            curr.removeAt(curr.size - 1)
        }
        return finalAns
    }
}


