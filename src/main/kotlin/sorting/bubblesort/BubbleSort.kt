package sorting.bubblesort

fun main() {
    val bubbleSort = BubbleSort()
    val input = intArrayOf(3, 5, 6, 9, 10, 11, 12)
    bubbleSort.bubbleSort(input)
    input.forEach { println(it) }
}

class BubbleSort {
    fun bubbleSort(input: IntArray) {
        var swapped = false
        val n = input.size
        for (i in input.indices) {
            // for each step, max item will come at the last respective index
            for (j in 1 until n - i) {
                //swap if the item is smaller than the previous item
                if (input[j] < input[j - 1]) {
                    val temp = input[j]
                    input[j] = input[j - 1]
                    input[j - 1] = temp
                    swapped = true
                }
            }
            // if we did not swap the perticular value of i, it means the array is sorted hence stop the execution
            if (!swapped)
                break
        }
    }
}