package graph

//https://leetcode.com/problems/find-center-of-star-graph/description/

fun main(args: Array<String>) {
    val input = arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(4, 2))
    val findTheCenterOfStrarGraph = FindTheCenterOfStrarGraph()
    println(findTheCenterOfStrarGraph.findCenter(input))
}

class FindTheCenterOfStrarGraph {

    fun findCenter(edges: Array<IntArray>): Int {
        // Calculate the indegrees

        val n = edges.size + 1
        val indegrees = IntArray(n + 1) { 0 }

        edges.forEach { (source, destination) ->
            indegrees[source]++
            indegrees[destination]++
        }

        for (i in 1..n) {
            if (indegrees[i] == n - 1) {
                return i
            }
        }

        return -1
    }
}