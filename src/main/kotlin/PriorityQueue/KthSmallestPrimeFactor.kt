package PriorityQueue

import java.util.*
import kotlin.math.floor

//https://leetcode.com/problems/k-th-smallest-prime-fraction/?envType=daily-question&envId=2024-05-10
fun main() {
    val kthSmallestPrimeFactor = KthSmallestPrimeFactor()
    val output = kthSmallestPrimeFactor.kthSmallestPrimeFraction(intArrayOf(1, 2, 3, 5), k = 3)

    println(output.distinct())

}

class KthSmallestPrimeFactor {

    // Two for loops for i an j pair
    // i=0 until size-1 j = i+1 until size
    // keep a track of fractions
    // PriorityQueue(min heap) will keep track of smallest elements
    // Add fractions in Priority Queue
    //Iterate PQ unitl K = 3
    // Poll top two elements and at last we will kth peek the elements
    // Now we need to keep a track of a[i] and a[j]
    //Triple or Prime Fraction class to hold the data
    // Priority Queue needs a comparator to define the priority

    fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {

        val n = arr.size

        val comparator = Comparator<PrimeFraction> { f1, f2 ->
            when {
                f1.fraction < f2.fraction -> -1  // Return -1 if f1 is less than f2
                f1.fraction > f2.fraction -> 1   // Return 1 if f1 is greater than f2
                else -> 0      // Return 0 if f1 is equal to f2
            }
        }

        val pq = PriorityQueue(comparator)

        for (i in 0 until n - 1) {
            for (j in i + 1 until n) {
                val fraction: Float = arr[i].toFloat() / arr[j].toFloat()
                pq.add(PrimeFraction(arr[i], arr[j], fraction))
            }
        }

        var count = 0

        while (pq.isNotEmpty() && count < k-1) {
            pq.poll()
            count++
        }
        while (pq.isNotEmpty()) {
            val kth = pq.poll()
            return intArrayOf(kth.i, kth.j)
        }
        return intArrayOf()
    }

    data class PrimeFraction(val i: Int, val j: Int, val fraction: Float)

}