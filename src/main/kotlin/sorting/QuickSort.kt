package sorting

fun main() {
    val input = intArrayOf(5, 2, 4, 6, 1, 3)
    val quickSort = QuickSort()
    quickSort.sort(input, 0, input.size-1)
    input.forEach { println(it) }

}

class QuickSort {

    fun sort(nums: IntArray, low: Int, high: Int) {
        if (low >= high) return

        var start = low
        var end = high
        val mid = start + (end - start) / 2
        val pivot = nums[mid] // taking middle as pivot

        while (start <= end) {

            while (nums[start] < pivot)
                start++

            while (nums[end] > pivot)
                end--

            if (start <= end) {
                val temp = nums[start]
                nums[start] = nums[end]
                nums[end] = temp
                start++
                end--
            }
        }

        // Pivot is at correct index, now sort two halves
        sort(nums, low, end)
        sort(nums, start, high)

    }
}