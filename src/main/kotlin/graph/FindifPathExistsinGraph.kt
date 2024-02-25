package graph

fun main(args: Array<String>) {
    val edges = arrayOf(
        intArrayOf(0, 7), intArrayOf(0, 8), intArrayOf(6, 1), intArrayOf(2, 0), intArrayOf(0, 4),
        intArrayOf(5, 8), intArrayOf(4, 7), intArrayOf(1, 3), intArrayOf(3, 5), intArrayOf(6, 5)
    )
    val findTheCenterOfStrarGraph = FindifPathExistsinGraph()
   println(findTheCenterOfStrarGraph.validPath(10, edges, 7, 5))
}

class FindifPathExistsinGraph {

    // There would be 10 nodes from 0 to 9
    fun validPath(n: Int, edges: Array<IntArray>, source: Int, destination: Int): Boolean {
        val graph = hashMapOf<Int, MutableList<Int>>()
        val visited = mutableSetOf<Int>()

        for (i in 0 until n) {
            graph[i] = mutableListOf()
        }

        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]

            graph[u]?.add(v)
            graph[v]?.add(u)
        }

        visited.add(source)
        return isValid(source, destination, graph, visited)
    }

    fun isValid(
        source: Int,
        destination: Int,
        graph: HashMap<Int, MutableList<Int>>,
        visited: MutableSet<Int>
    ): Boolean {
        if (source == destination) return true

        // if(visited.contains(source)) return false

        var isValid = false
        val neighbors = graph[source]
        if (neighbors != null) {
            for (i in 0 until neighbors.size) {
                if (!visited.contains(neighbors[i])) {
                    visited.add(neighbors[i])
                    isValid = isValid || isValid(neighbors[i], destination, graph, visited)
                }
            }
        }
        return isValid
    }
}