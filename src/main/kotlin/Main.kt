import java.util.*

// Find Min and Max functions
//https://www.techiedelight.com/find-minimum-maximum-element-array-kotlin/

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
//    println("Program arguments: ${args.joinToString()}")

//    val input = intArrayOf(17, 12, 10, 2, 7, 2, 11, 20, 8)
    val input = intArrayOf(
        1, 2, 4, 1
    )
    println(totalCost(input, 3, 3))
}

fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
    // min heap priority queue
    // push all the elements to queue
    // smallest will be at top

    var totalCost = 0L
    val pqLeft = PriorityQueue<Int> { a, b -> a - b }
    val pqRight = PriorityQueue<Int> { a, b -> a - b }

    var l = 0
    var r = costs.size - 1
    for (i in 0 until candidates) {
        pqLeft.add(costs[l])
        l++
        pqRight.add(costs[r])
        r--
    }
    var count = 0
    // we need to push until we are l<=r
    while (count < k) {

        val leftPeek = pqLeft.peek()
        val rightPeek = pqRight.peek()

        if (leftPeek <= rightPeek) {
            totalCost += pqLeft.poll()
            if (l < costs.size) {
                pqLeft.add(costs[l])
            }
            l++
        } else {
            totalCost += pqRight.poll()
            if (r >= 0) {
                pqRight.add(costs[r])
            }
            r--
        }

        count++
    }



    return totalCost % 100_000_007
}

fun copy(costs: IntArray, k: Int, candidates: Int): Long {
    val pqL = PriorityQueue<Int>()
    val pqR = PriorityQueue<Int>()
    var lo = 0
    var hi = costs.lastIndex
    var sum = 0L
    var count = 0
    if (2 * candidates >= costs.size) while (lo <= hi) pqL.add(costs[lo++])
    while (pqL.size < candidates && lo <= hi) pqL.add(costs[lo++])
    while (pqR.size < candidates && lo < hi) pqR.add(costs[hi--])
    while (lo <= hi && count++ < k) {
        if (pqR.peek() < pqL.peek()) {
            sum += pqR.poll()
            pqR.add(costs[hi--])
        } else {
            sum += pqL.poll()
            pqL.add(costs[lo++])
        }
    }
    while (pqR.isNotEmpty()) pqL.add(pqR.poll())
    while (count++ < k && pqL.isNotEmpty()) sum += pqL.poll()
    return sum
}

fun getMax(A: IntArray): Int {
    var max = Int.MIN_VALUE
    for (i in A) {
        max = max.coerceAtLeast(i)
    }
    return max
}