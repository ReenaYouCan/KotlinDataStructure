package recursion.binarysearch

fun main() {
    // Create an instance of RotatedBinarySearch
    val rotatedBinarySearch = RotatedBinarySearch()

    // Input array is a rotated sorted array
    val input = intArrayOf(4, 5, 6, 7, 0, 1, 2)

    // Search for the target value (8) and print the result
    println(rotatedBinarySearch.search(input, 0, input.size - 1, 5))
}

class RotatedBinarySearch {

    /**
     * Recursive function to perform a search in a rotated sorted array.
     * @param arr The rotated sorted array.
     * @param start The starting index of the current search range.
     * @param end The ending index of the current search range.
     * @param target The value to search for.
     * @return The index of the target in the array, or -1 if not found.
     */
    fun search(arr: IntArray, start: Int, end: Int, target: Int): Int {

        // Base case: If the range is invalid, return -1 (target not found)
        if (start > end) return -1

        // Calculate the middle index of the current range
        val mid = start + (end - start) / 2

        // Check if the middle element is the target
        if (arr[mid] == target) return mid

        // Case 1 - Check if the left half (start to mid) of the array is sorted
        if (arr[start] <= arr[mid]) {
            // If the target lies within the sorted left half, search there
            if (target <= arr[mid] && target >= arr[start])
                return search(arr, start, mid - 1, target)
            else
            // Otherwise, search in the right half
                return search(arr, mid + 1, end, target)
        }

        // Case 2- If the left half is not sorted, the right half must be sorted
        if (target >= arr[mid] && target <= arr[end]) {
            // If the target lies within the sorted right half, search there
            return search(arr, mid + 1, end, target)
        } else
        // Otherwise, search in the left half
            return search(arr, start, mid - 1, target)
    }

    /**
     * Test Cases with Explanations:
     * Target in the left sorted half
     * Array: [4, 5, 6, 7, 0, 1, 2]
     * Target: 5
     * Explanation: The target 5 lies in the left half of the array, which is sorted.
     * Expected Output: 1
     *
     * Target in the right sorted half
     * Array: [4, 5, 6, 7, 0, 1, 2]
     * Target: 1
     * Explanation: The target 1 lies in the right half of the array, which is sorted.
     * Expected Output: 5
     *
     * Target is the middle element
     * Array: [4, 5, 6, 7, 0, 1, 2]
     * Target: 7
     * Explanation: The target 7 is at the middle index.
     * Expected Output: 3
     *
     * Target is not in the array
     * Array: [4, 5, 6, 7, 0, 1, 2]
     * Target: 10
     * Explanation: The target 10 is not in the array.
     * Expected Output: -1
     *
     * Target in the leftmost position
     * Array: [4, 5, 6, 7, 0, 1, 2]
     * Target: 4
     * Explanation: The target 4 is the first element in the array.
     * Expected Output: 0
     *
     * Target in the rightmost position
     * Array: [4, 5, 6, 7, 0, 1, 2]
     * Target: 2
     * Explanation: The target 2 is the last element in the array.
     * Expected Output: 6
     *
     * Array is not rotated (standard binary search)
     * Array: [1, 2, 3, 4, 5, 6, 7]
     * Target: 6
     * Explanation: The array is not rotated, and the target 6 is found using a standard binary search.
     * Expected Output: 5
     *
     * Array is rotated at a single point
     * Array: [2, 1]
     * Target: 1
     * Explanation: The array is rotated at one point, and the target 1 is in the right half.
     * Expected Output: 1
     */
}
