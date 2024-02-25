package graph

import java.util.*


class MinnimumSpanningTree {
}

fun findCriticalAndPseudoCriticalEdges(n: Int, edges: Array<IntArray>): List<MutableList<Int>> {
    // Add index to edges for tracking
    val m = edges.size
    val newEdges = Array(m) { IntArray(4) }
    for (i in 0 until m) {
        for (j in 0..2) {
            newEdges[i][j] = edges[i][j]
        }
        newEdges[i][3] = i
    }

    // Sort edges based on weight
    Arrays.sort(newEdges, compareBy() { edge: IntArray ->
        edge[2]
    })

//        edges.sortWith(compareByDescending { it[2] })

    // Find MST weight using union-find
    val ufStd = UnionFind(n)
    var stdWeight = 0
    for (edge in newEdges) {
        if (ufStd.union(edge[0], edge[1])) {
            stdWeight += edge[2]
        }
    }
    val result: MutableList<MutableList<Int>> = ArrayList()
    for (i in 0..1) {
        result.add(ArrayList())
    }

    // Check each edge for critical and pseudo-critical
    for (i in 0 until m) {
        // Ignore this edge and calculate MST weight
        val ufIgnore = UnionFind(n)
        var ignoreWeight = 0
        for (j in 0 until m) {
            if (i != j && ufIgnore.union(newEdges[j][0], newEdges[j][1])) {
                ignoreWeight += newEdges[j][2]
            }
        }
        // If the graph is disconnected or the total weight is greater,
        // the edge is critical
        if (ufIgnore.maxSize < n || ignoreWeight > stdWeight) {
            result[0].add(newEdges[i][3])
        } else {
            // Force this edge and calculate MST weight
            val ufForce = UnionFind(n)
            ufForce.union(newEdges[i][0], newEdges[i][1])
            var forceWeight = newEdges[i][2]
            for (j in 0 until m) {
                if (i != j && ufForce.union(newEdges[j][0], newEdges[j][1])) {
                    forceWeight += newEdges[j][2]
                }
            }
            // If total weight is the same, the edge is pseudo-critical
            if (forceWeight == stdWeight) {
                result[1].add(newEdges[i][3])
            }
        }
    }
    return result
}

internal class UnionFind(n: Int) {
    var parent: IntArray
    var size: IntArray
    var maxSize: Int

    init {
        parent = IntArray(n)
        size = IntArray(n)
        maxSize = 1
        for (i in 0 until n) {
            parent[i] = i
            size[i] = 1
        }
    }

    fun find(x: Int): Int {
        // Finds the root of x
        if (x != parent[x]) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }

    fun union(x: Int, y: Int): Boolean {
        // Connects x and y
        var rootX = find(x)
        var rootY = find(y)
        if (rootX != rootY) {
            if (size[rootX] < size[rootY]) {
                val temp = rootX
                rootX = rootY
                rootY = temp
            }
            parent[rootY] = rootX
            size[rootX] += size[rootY]
            maxSize = Math.max(maxSize, size[rootX])
            return true
        }
        return false
    }
}
