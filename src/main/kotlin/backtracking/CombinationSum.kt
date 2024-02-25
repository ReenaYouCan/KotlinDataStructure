package backtracking

fun main(args: Array<String>) {
    val combinationSum = CombinationSum()
    val list = intArrayOf(2,3,5)
    val result = combinationSum.combinationSum(list, 8)

    for (ls in result) {
        for (j in ls.indices) {
            print(ls[j])
        }
        println()
    }

}

class CombinationSum {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        helper(0, 0, candidates, target, mutableListOf<Int>(), result)
        return result
    }

    fun helper(
        i: Int,
        sum: Int,
        candidates: IntArray,
        target: Int,
        tempList: MutableList<Int>,
        result: MutableList<MutableList<Int>>
    ) {
        val n = candidates.size
        if (i >= n || sum > target) return

        if (sum == target) {
            val list = tempList.toMutableList()
            result.add(list)
            return
        }

        tempList.add(candidates[i])
        helper(i, sum + candidates[i], candidates, target, tempList, result)
        tempList.removeAt(tempList.size - 1)
        helper(i + 1, sum, candidates, target, tempList, result)

    }

    // currSumm == target
    // index >=candidates.size || currSum > target
    //    return 0

    // keep adding current element until not reaching base case

    // take current and add it to the sum
    // skip current and dont take that element to the sum


}
