package sorting.selectionsort

fun main() {

    val sectionSort = SelectionSort()
    val input = intArrayOf(3, 5, 6, 9, 10, 1, 1)
    sectionSort.sort(input)
    input.forEach { print(" $it") }
}

class SelectionSort {

    fun sort(input: IntArray) {
        val n = input.size
        for (i in input.indices) {
            //find maximum item in the remaining array and swap with the correct index
            val lastIndex = n - i - 1
            val maxIndex = getMaxIndex(input, 0, lastIndex)

            swap(input, maxIndex, lastIndex)
        }
    }

    private fun getMaxIndex(input: IntArray, start: Int, end: Int): Int {
        var max = start
        for (i in start..end) {
            if (input[max] < input[i])
                max = i
        }
        return max
    }

    fun swap(input: IntArray, first: Int, second: Int) {
        val temp = input[first]
        input[first] = input[second]
        input[second] = temp
    }
}