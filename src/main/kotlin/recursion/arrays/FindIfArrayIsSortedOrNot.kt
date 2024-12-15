package recursion.arrays

fun main() {
//    println(FindIfArrayIsSortedOrNot.isSorted(0, intArrayOf(1, 1, 2, 3, 1, 23)))
//    println(FindIfArrayIsSortedOrNot.search(0, 10, intArrayOf(20, 30, 12, 35, 12, 0)))
//
//    FindIfArrayIsSortedOrNot.searchAllIndex(0, 3, intArrayOf(1, 1, 2, 3, 3, 3, 3, 3))
//    FindIfArrayIsSortedOrNot.indexList.forEach { println(it) }

//    FindIfArrayIsSortedOrNot.searchAllIndexReturnList(0, 1, intArrayOf(1, 1, 2, 3,6,7,8,9), arrayListOf()).forEach {
//        println(it)
//    }

    FindIfArrayIsSortedOrNot.searchAllIndexReturnList(0,1, intArrayOf(1, 1, 2, 3,6,7,8,9)).forEach {
        print(" $it")
    }
}

object FindIfArrayIsSortedOrNot {
    // check if array is sorted or not

    fun isSorted(i: Int, nums: IntArray): Boolean {
        if (i + 1 >= nums.size)
            return true

        if (nums[i] > nums[i + 1]) {
            return false
        }

        return isSorted(i + 1, nums)
    }

    fun search(i: Int, target: Int, nums: IntArray): Boolean {
        if (i >= nums.size)
            return false

        if (nums[i] == target)
            return true

        return search(i + 1, target, nums)

    }

    val indexList = arrayListOf<Int>()
    fun searchAllIndex(i: Int, target: Int, nums: IntArray) {
        if (i >= nums.size)
            return

        if (nums[i] == target) {
            indexList.add(i)
        }

        searchAllIndex(i + 1, target, nums)
    }


    fun searchAllIndexReturnList(i: Int, target: Int, nums: IntArray, result: ArrayList<Int>): ArrayList<Int> {
        if (i >= nums.size)
            return result

        if (nums[i] == target) {
            result.add(i)
        }

        return searchAllIndexReturnList(i + 1, target, nums, result)
    }

    // Returning the list without passing in argument

    fun searchAllIndexReturnList(i: Int, target: Int, nums: IntArray): MutableList<Int> {
        val mutableList = mutableListOf<Int>()
        if (i >= nums.size)
            return mutableList

        if (nums[i] == target) {
            mutableList.add(i)
        }

        val downList = searchAllIndexReturnList(i + 1, target, nums)
        mutableList.addAll(downList)

        return mutableList
    }
}