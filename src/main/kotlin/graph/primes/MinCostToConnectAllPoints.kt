package graph.primes

import java.util.*


class MinCostToConnectAllPoints {
    //    https://leetcode.com/problems/min-cost-to-connect-all-points/?envType=daily-question&envId=2023-09-15
    internal class Solution {
        fun minCostConnectPoints(points: Array<IntArray>): Int {
            val n = points.size // Number of points
            var mstCost = 0 // Total cost of the minimum spanning tree
            var edgesUsed = 0 // Number of edges used in the MST

            // Track nodes which are visited.
            val inMST = BooleanArray(n) // Boolean array to mark nodes in MST
            val minDist = IntArray(n) // Array to store minimum distances
            minDist[0] = 0 // Initialize distance to the first node (0th index) as 0
            for (i in 1 until n) {
                minDist[i] = Int.MAX_VALUE // Initialize distances to other nodes as infinity
            }

            // Continue until all nodes are in the MST
            while (edgesUsed < n) {
                var currMinEdge = Int.MAX_VALUE // Initialize the minimum edge weight to infinity
                var currNode = -1 // Initialize the current node

                // Pick the node with the least weight which is not in MST.
                for (node in 0 until n) {
                    if (!inMST[node] && currMinEdge > minDist[node]) {
                        currMinEdge = minDist[node]
                        currNode = node
                    }
                }

                mstCost += currMinEdge // Add the current minimum edge weight to the MST cost
                edgesUsed++ // Increment the number of edges used
                inMST[currNode] = true // Mark the current node as part of MST

                // Update adjacent nodes of the current node.
                for (nextNode in 0 until n) {
                    val weight = Math.abs(points[currNode][0] - points[nextNode][0]) +
                            Math.abs(points[currNode][1] - points[nextNode][1])
                    if (!inMST[nextNode] && minDist[nextNode] > weight) {
                        minDist[nextNode] = weight // Update minimum distance if a shorter path is found
                    }
                }
            }

            return mstCost // Return the total cost of the minimum spanning tree
        }


    }
}

internal class Solution {
    private fun binarySearch(row: IntArray): Int {
        var low = 0
        var high = row.size
        while (low < high) {
            val mid = low + (high - low) / 2
            if (row[mid] == 1) {
                low = mid + 1
            } else {
                high = mid
            }
        }
        return low
    }

    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val m = mat.size
        val n = mat[0].size

        // Create a Priority Queue that measures firstly on strength and then indexes.
        val pq = PriorityQueue(java.util.Comparator { a: IntArray, b: IntArray ->
            if (a[0] == b[0]
            ) return@Comparator b[1] - a[1] else return@Comparator b[0] - a[0]
        })

        // Add strength/index pairs to the pq. Whenever length > k, remove the largest.
        for (i in 0 until m) {
            val strength = binarySearch(mat[i])
            val entry = intArrayOf(strength, i)
            pq.add(entry)
            if (pq.size > k) {
                pq.poll()
            }
        }

        // Pull the indexes out of the priority queue.
        val indexes = IntArray(k)
        for (i in k - 1 downTo 0) {
            val pair = pq.poll()
            indexes[i] = pair[1]
        }
        return indexes
    }
}

