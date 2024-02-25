package array

fun main(args: Array<String>) {
    val removeFromSortedArray = RemoveFromSortedArray()
    val result = removeFromSortedArray.removeDuplicates(intArrayOf(1, 1, 2, 2, 3))
    println(result)
}

class RemoveFromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        var i = 0
        var j = 0


        for (curr in 0 until nums.size - 1) {
            if (nums[curr] != nums[curr + 1]) {
                nums[j] = nums[curr+1]
                j++

            }
        }

        return j + 1
    }
}