package binarysearch

import trees.basics.BinarySearchTreeBasics

fun main(args: Array<String>) {
    println(search(intArrayOf(2, 5, 6, 0, 0, 1, 2), 0))
}

fun search(nums: IntArray, target: Int): Boolean {
    val n = nums.size

    val pivot = findPivot(0, n - 1, nums)

    val left = binarysearch(0, pivot - 1, target, nums)

    if (left)
        return true

    return binarysearch(pivot, n - 1, target, nums)
}

fun binarysearch(left: Int, right: Int, target: Int, nums: IntArray): Boolean {

    var l = left
    var r = right
    while (l < r) {
        val mid = l + (r - l) / 2
        if (nums[mid] == target) {
            return true
        } else if (target > nums[mid]) {
            l = mid + 1
        } else {
            r = mid
        }
    }
    return false
}

fun findPivot(left: Int, right: Int, nums: IntArray): Int {
    var l = left
    var r = right
    while (l < r) {

        while (l < r && nums[l] == nums[l + 1]) {
            l++
        }

        while (l < r && nums[r] == nums[r - 1]) {
            r--
        }

        val mid = l + (r - l) / 2
        if (nums[mid] > nums[r]) {
            l = mid + 1
        } else {
            r = mid
        }
    }
    return r
}

