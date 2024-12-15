package sorting

fun main() {
    val mergeSort = MergeSort()
    val input = intArrayOf(39, 28, 61,50)
    mergeSort.sort(input, 0, input.size - 1)
    println("Sorted Array")
    input.forEach { print("$it ") }
}

class MergeSort {

    /**
     * Main function that sorts arr[left ..right] using merge()
     *
     * @param arr The array to sort
     * @param left The starting index of the array segment to sort
     * @param right The ending index of the array segment to sort
     */
    fun sort(arr: IntArray, left: Int, right: Int) {
        if (left < right) {
            // Find the middle point to divide the array
            val mid = left + (right - left) / 2

            //recursively sort the first and secod halves
            sort(arr, left, mid)
            sort(arr, mid + 1, right)

            //Merge the sorted halves
            merge(arr, left, mid, right)
        }
    }


    /**
     * Merges two subarrays of arr[].
     * - First subarray is arr[left ..mid]
     * - Second subarray is arr[mid+1..right]
     *
     * @param arr The array containing the subarrays to merge
     * @param left The starting index of the first subarray
     * @param mid The ending index of the first subarray
     * @param right The ending index of the second subarray
     */
    fun merge(arr: IntArray, left: Int, mid: Int, right: Int) {

        // Find sizes of the two subarrays to be merged
        val leftArraySize = mid - left + 1
        val rightArraySize = right - mid

        // Create temporary arrays for the two subarrays
        val leftArray = IntArray(leftArraySize) { arr[left + it] }
        val rightArray = IntArray(rightArraySize) { arr[mid + 1 + it] }

        var iL = 0 // index for left array
        var iR = 0 // index for right array
        var iM = left //Index for merged array

        //Compare and merge elements from leftArray and rightArray
        while (iL < leftArraySize && iR < rightArraySize) {
            if (leftArray[iL] < rightArray[iR]) {
                arr[iM] = leftArray[iL]
                iL++
            } else {
                arr[iM] = rightArray[iR]
                iR++
            }
            iM++
        }

        // Copy remaining elements from leftArray, if any
        while (iL < leftArraySize) {
            arr[iM] = leftArray[iL]
            iL++
            iM++
        }

        // Copy remaining elements from rightArray, if any
        while (iR < rightArraySize) {
            arr[iM] = rightArray[iR]
            iR++
            iM++
        }

    }


}