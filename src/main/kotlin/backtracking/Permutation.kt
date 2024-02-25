package backtracking

fun main(args: Array<String>) {
    val permutation = Permutation()
    permutation.permute(intArrayOf(1, 2, 3))
}

class Permutation {
    fun permute(nums: IntArray): List<List<Int>> {
        val ans: MutableList<List<Int>> = ArrayList()
        backtrack(ArrayList(), ans, nums)
        return ans
    }

    fun backtrack(curr: MutableList<Int>, ans: MutableList<List<Int>>, nums: IntArray) {
        if (curr.size == nums.size) {
            ans.add(ArrayList(curr))
            return
        }
        for (num in nums) {
            if (!curr.contains(num)) {
                curr.add(num)
                backtrack(curr, ans, nums)
                curr.removeAt(curr.size - 1)
            }
        }
    }

}