package graph.bfs

import java.util.*


fun main(args: Array<String>) {
    val zeroOneMatrix = ZeroOneMatrix()
    val input = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0))
    val result = zeroOneMatrix.updateMatrix(input)

    for (row in result.indices) {
        for (col in 0 until result[0].size) {
            print(result[row][col])
            print(" ")
        }
        println()
    }

}

class ZeroOneMatrix {
    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val directions = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
        val row = mat.size
        val col = mat[0].size
        val result = Array(row) { IntArray(col) { -1 } }
        // Take a queue to perform bfs operation
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        // Add all zeros to queue
        for (r in 0 until row) {
            for (c in 0 until col) {
                if (mat[r][c] == 0) {
                    result[r][c] = 0
                    queue.add(Pair(r, c))
                }
            }
        }

        while (queue.isNotEmpty()) {
            val pair = queue.poll()

            // We need to
            for (dir in directions) {
                val r = pair.first + dir[0]
                val c = pair.second + dir[1]

                if (r >= 0 && c >= 0 && r < row && c < col && result[r][c] == -1) {
                    result[r][c] = 1 + result[pair.first][pair.second]
                    queue.add(Pair(r, c))
                }
            }

        }


        return result
    }


}

internal class Solution {

}