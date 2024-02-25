package PriorityQueue

fun maxProbability(n: Int, edges: Array<IntArray>, succProb: DoubleArray, start: Int, end: Int): Double {
    val maxProb = DoubleArray(n)
    maxProb[start] = 1.0
    for (i in 0 until n - 1) {
        var hasUpdate = false
        for (j in edges.indices) {
            val u = edges[j][0]
            val v = edges[j][1]
            val pathProb = succProb[j]
            if (maxProb[u] * pathProb > maxProb[v]) {
                maxProb[v] = maxProb[u] * pathProb
                hasUpdate = true
            }
            if (maxProb[v] * pathProb > maxProb[u]) {
                maxProb[u] = maxProb[v] * pathProb
                hasUpdate = true
            }
        }
        if (!hasUpdate) {
            break
        }
    }
    return maxProb[end]
}

// A Kotlin program for Bellman-Ford's single source
// shortest path algorithm.
internal object GFG {
    // The main function that finds shortest
    // distances from src to all other vertices
    // using Bellman-Ford algorithm. The function
    // also detects negative weight cycle
    // The row graph[i] represents i-th edge with
    // three values u, v and w.
    fun BellmanFord(
        graph: Array<IntArray>, V: Int, E: Int,
        src: Int
    ) {
        // Initialize distance of all vertices as infinite.
        val dis = IntArray(V)
        for (i in 0 until V) dis[i] = Int.MAX_VALUE

        // initialize distance of source as 0
        dis[src] = 0

        // Relax all edges |V| - 1 times. A simple
        // shortest path from src to any other
        // vertex can have at-most |V| - 1 edges
        for (i in 0 until V - 1) {
            for (j in 0 until E) {
                if (dis[graph[j][0]] != Int.MAX_VALUE && dis[graph[j][0]] + graph[j][2] <
                    dis[graph[j][1]]
                ) dis[graph[j][1]] = dis[graph[j][0]] + graph[j][2]
            }
        }

        // check for negative-weight cycles.
        // The above step guarantees shortest
        // distances if graph doesn't contain
        // negative weight cycle. If we get a
        // shorter path, then there is a cycle.
        for (i in 0 until E) {
            val x = graph[i][0]
            val y = graph[i][1]
            val weight = graph[i][2]
            if (dis[x] != Int.MAX_VALUE &&
                dis[x] + weight < dis[y]
            ) println(
                "Graph contains negative"
                        + " weight cycle"
            )
        }
        println("Vertex Distance from Source")
        for (i in 0 until V) println(i.toString() + "\t\t" + dis[i])
    }

    // Driver code
    @JvmStatic
    fun main(args: Array<String>) {
        val V = 5 // Number of vertices in graph
        val E = 8 // Number of edges in graph

        // Every edge has three values (u, v, w) where
        // the edge is from vertex u to v. And weight
        // of the edge is w.
        val graph = arrayOf(
            intArrayOf(0, 1, -1),
            intArrayOf(0, 2, 4),
            intArrayOf(1, 2, 3),
            intArrayOf(1, 3, 2),
            intArrayOf(1, 4, 2),
            intArrayOf(3, 2, 5),
            intArrayOf(3, 1, 1),
            intArrayOf(4, 3, -3)
        )
        BellmanFord(graph, V, E, 0)
    }
}