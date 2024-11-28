package sorting

fun main() {
    val insertionSort = InsertionSort()
    val input = intArrayOf(5, 2, 4, 6, 1, 3)
    insertionSort.sort(input)
    input.forEach { println(it) }
}

class InsertionSort {

    fun sort(nums: IntArray) {
        // need to get a key from unsorted array

        for (i in 1 until nums.size) {
            val key = nums[i]

            var j = i - 1

            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j]
                j--
            }
            nums[j + 1] = key

        }

    }

}
