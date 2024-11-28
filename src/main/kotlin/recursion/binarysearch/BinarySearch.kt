package recursion.binarysearch

fun main() {
    val binarySearch = BinarySearch()

    val nums = intArrayOf(20, 30, 31, 32, 33, 40, 50)

    println(binarySearch.search(20, nums, 0, nums.size - 1))
}

class BinarySearch {

    fun search(num: Int, nums: IntArray, start: Int, end: Int): Int {
        // start
        // end
        // mid
        // compare mid with current num[i]
        // else check if given num is greater than mid then move to right
        // else serach in left
        // Assumption array should be sorted

        // base case i will exceed size of num then return -1

        val n = nums.size
        if (start >= n || start < 0 || end >= n || end < 0 )
            return -1

        val mid = start + (end - start) / 2
        if (nums[mid] == num) return mid
        // search in right side
        if (nums[mid] < num)
            return search(num, nums, mid+1, end)
        else return search(num, nums, start, mid-1)


    }

}