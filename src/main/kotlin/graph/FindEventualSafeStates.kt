package graph

import java.util.*


class FindEventualSafeStates {
}

fun eventualSafeNodes(graph: Array<IntArray>): List<Int> {
    val n = graph.size
    val indegree = IntArray(n)
    val adj: MutableList<MutableList<Int>> = ArrayList()
    for (i in 0 until n) {
        adj.add(ArrayList())
    }
    for (i in 0 until n) {
        for (node in graph[i]) {
            adj[node].add(i)
            indegree[i]++
        }
    }
    val q: Queue<Int> = LinkedList()
    // Push all the nodes with indegree zero in the queue.
    for (i in 0 until n) {
        if (indegree[i] == 0) {
            q.add(i)
        }
    }
    val safe = BooleanArray(n)
    while (!q.isEmpty()) {
        val node = q.poll()
        safe[node] = true
        for (neighbor in adj[node]) {
            // Delete the edge "node -> neighbor".
            indegree[neighbor]--
            if (indegree[neighbor] == 0) {
                q.add(neighbor)
            }
        }
    }
    val safeNodes: MutableList<Int> = ArrayList()
    for (i in 0 until n) {
        if (safe[i]) {
            safeNodes.add(i)
        }
    }
    return safeNodes
}
