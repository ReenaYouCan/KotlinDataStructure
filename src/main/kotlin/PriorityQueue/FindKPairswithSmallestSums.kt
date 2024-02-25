package PriorityQueue

import java.util.*


fun main(args: Array<String>) {
    val nums1 = intArrayOf(1, 1, 2)
    val nums2 = intArrayOf(1, 2, 3)

    val output = kSmallestPairs(nums1, nums2, 2)

    output?.forEach { list -> list.forEach { num -> println(num) } }
//    kSmallestPairs(nums1, nums2, 2)
}

// Brute Force
fun kSmallestPairsBF(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()

    val pq = PriorityQueue<IntArray> { a1, a2 -> (a1[0] + a1[1]) - (a2[0] + a2[1]) }

    for (i in nums1.indices) {
        for (j in nums2.indices) {
            val pair = intArrayOf(nums1[i], nums2[j])
            pq.add(pair)
        }
    }
    var count = 0
    while (pq.isNotEmpty() && count < k) {
        val pair = pq.poll()
        result.add(pair.toList())
        count++
    }
    return result
}

// Optimal
fun kSmallestPairs(nums1: IntArray, nums2: IntArray, k: Int): List<List<Int>> {
    var k = k
    val m = nums1.size
    val n = nums2.size
    val ans: MutableList<List<Int>> = ArrayList()
    val visited: MutableSet<Pair<Int, Int>> = HashSet()
    val minHeap = PriorityQueue { a: IntArray, b: IntArray ->
        a[0] - b[0] // Sorting based on sum
    }
    minHeap.offer(intArrayOf(nums1[0] + nums2[0], 0, 0))
    visited.add(Pair(0, 0))
    while (k-- > 0 && !minHeap.isEmpty()) {
        val top = minHeap.poll()
        val i = top[1]
        val j = top[2]
        ans.add(listOf(nums1[i], nums2[j]))
        if (i + 1 < m && !visited.contains(Pair(i + 1, j))) {
            minHeap.offer(intArrayOf(nums1[i + 1] + nums2[j], i + 1, j))
            visited.add(Pair(i + 1, j))
        }
        if (j + 1 < n && !visited.contains(Pair(i, j + 1))) {
            minHeap.offer(intArrayOf(nums1[i] + nums2[j + 1], i, j + 1))
            visited.add(Pair(i, j + 1))
        }
    }
    return ans
}