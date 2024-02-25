package graph.dijkstra

import java.util.*


//https://leetcode.com/problems/path-with-minimum-effort/description/?envType=daily-question&envId=2023-09-16
class PathWithMinimumEffort {

    fun minimumEffortPath(heights: Array<IntArray>): Int {

//        var ou : Int = 0
        val row = heights.size
        val col = heights[0].size

        val result = Array(row) { IntArray(col) { Int.MAX_VALUE } }

        val queue = PriorityQueue<Pair<Int, Int>>()


        return 0
    }

    internal class Solution {
        fun minimumEffortPath(heights: Array<IntArray>): Int {
            val row = heights.size
            val col = heights[0].size

            // Create a matrix to store the difference in efforts to reach each cell.
            val differenceMatrix = Array(row) { IntArray(col) {Int.MAX_VALUE} }

            // Initialize the differenceMatrix with maximum values except for the start cell.
            differenceMatrix[0][0] = 0

            // Create a priority queue to track cells based on their difference in heights.
            val queue = PriorityQueue { a: Cell, b: Cell ->
                a.difference.compareTo(b.difference)
            }

            // Create a matrix to keep track of visited cells.
            val visited = Array(row) { BooleanArray(col) }

            // Add the start cell to the priority queue.
            queue.add(Cell(0, 0, differenceMatrix[0][0]))

            // Define possible directions for moving to adjacent cells.
            val directions = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

            while (!queue.isEmpty()) {
                val curr = queue.poll()
                visited[curr.x][curr.y] = true

                // If we reach the destination cell, return the difference in effort.
                if (curr.x == row - 1 && curr.y == col - 1) return curr.difference

                // Explore adjacent cells.
                for (direction in directions) {
                    val adjacentX = curr.x + direction[0]
                    val adjacentY = curr.y + direction[1]

                    // Check if the adjacent cell is valid and not visited.
                    if (isValidCell(adjacentX, adjacentY, row, col) && !visited[adjacentX][adjacentY]) {
                        val currentDifference = Math.abs(heights[adjacentX][adjacentY] - heights[curr.x][curr.y])

                        // Calculate the maximum difference between the current and previous cells.
                        val maxDifference = Math.max(currentDifference, differenceMatrix[curr.x][curr.y])

                        // Update the differenceMatrix and add the cell to the queue.
                        if (differenceMatrix[adjacentX][adjacentY] > maxDifference) {
                            differenceMatrix[adjacentX][adjacentY] = maxDifference
                            queue.add(Cell(adjacentX, adjacentY, maxDifference))
                        }
                    }
                }
            }

            // Return the difference in effort for the destination cell.
            return differenceMatrix[row - 1][col - 1]
        }

        fun isValidCell(x: Int, y: Int, row: Int, col: Int): Boolean {
            return x >= 0 && x <= row - 1 && y >= 0 && y <= col - 1
        }

        internal class Cell(var x: Int, var y: Int, var difference: Int)

    }
}

