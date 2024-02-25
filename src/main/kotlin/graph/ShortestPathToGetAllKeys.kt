package graph

import java.util.*


internal class Solution {
    fun shortestPathAllKeys(grid: Array<String>): Int {
        val m = grid.size
        val n = grid[0].length
        val queue: Queue<IntArray> = LinkedList()
        val moves = arrayOf(intArrayOf(0, 1), intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, -1))

        // seen['key'] is only for BFS with key state equals 'keys'
        val seen: MutableMap<Int, MutableSet<Pair<Int, Int>>> = HashMap()
        val keySet: MutableSet<Char> = HashSet()
        val lockSet: MutableSet<Char> = HashSet()
        var allKeys = 0
        var startR = -1
        var startC = -1
        for (i in 0 until m) {
            for (j in 0 until n) {
                val cell = grid[i][j]
                if (cell >= 'a' && cell <= 'f') {
                    allKeys += 1 shl cell.code - 'a'.code
                    keySet.add(cell)
                }
                if (cell >= 'A' && cell <= 'F') {
                    lockSet.add(cell)
                }
                if (cell == '@') {
                    startR = i
                    startC = j
                }
            }
        }

        // [row, column, key state, distance]
        queue.offer(intArrayOf(startR, startC, 0, 0))
        seen[0] = HashSet()
        seen[0]!!.add(Pair(startR, startC))
        while (!queue.isEmpty()) {
            val cur = queue.poll()
            val curR = cur[0]
            val curC = cur[1]
            val keys = cur[2]
            val dist = cur[3]
            for (move in moves) {
                val newR = curR + move[0]
                val newC = curC + move[1]

                // If this cell (newR, newC) is reachable.
                if (newR in 0 until m && newC >= 0 && newC < n && grid[newR][newC] != '#') {
                    val cell = grid[newR][newC]

                    // If it is a key:
                    if (keySet.contains(cell)) {
                        // If we have collected it before, no need to revisit this cell.
                        if (1 shl cell.code - 'a'.code and keys != 0) {
                            continue
                        }

                        // Otherwise, we can walk to this cell and pick it up.
                        val newKeys = keys or (1 shl cell.code - 'a'.code)

                        // If we collect all keys, return dist + 1.
                        // Otherwise, just add this state to seen and queue.
                        if (newKeys == allKeys) {
                            return dist + 1
                        }
                        seen.putIfAbsent(newKeys, HashSet())
                        seen[newKeys]!!.add(Pair(newR, newC))
                        queue.offer(intArrayOf(newR, newC, newKeys, dist + 1))
                    }

                    // If it is a lock and we don't have its key, continue.
                    if (lockSet.contains(cell) && keys and (1 shl cell.code - 'A'.code) == 0) {
                        continue
                    } else if (!seen[keys]!!.contains(Pair(newR, newC))) {
                        seen[keys]!!.add(Pair(newR, newC))
                        queue.offer(intArrayOf(newR, newC, keys, dist + 1))
                    }
                }
            }
        }
        return -1
    }

    internal class Solution {
        private val directions = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
        fun canCross(row: Int, col: Int, cells: Array<IntArray>, day: Int): Boolean {
            val grid = Array(row) { IntArray(col) }
            val queue: Queue<IntArray> = LinkedList()
            for (i in 0 until day) {
                grid[cells[i][0] - 1][cells[i][1] - 1] = 1
            }
            for (i in 0 until col) {
                if (grid[0][i] == 0) {
                    queue.offer(intArrayOf(0, i))
                    grid[0][i] = -1
                }
            }
            while (!queue.isEmpty()) {
                val cur = queue.poll()
                val r = cur[0]
                val c = cur[1]
                if (r == row - 1) {
                    return true
                }
                for (dir in directions) {
                    val newRow = r + dir[0]
                    val newCol = c + dir[1]
                    if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && grid[newRow][newCol] == 0) {
                        grid[newRow][newCol] = -1
                        queue.offer(intArrayOf(newRow, newCol))
                    }
                }
            }
            return false
        }

        fun latestDayToCross(row: Int, col: Int, cells: Array<IntArray>): Int {
            var left = 1
            var right = row * col
            while (left < right) {
                val mid = right - (right - left) / 2
                if (canCross(row, col, cells, mid)) {
                    left = mid
                } else {
                    right = mid - 1
                }
            }
            return left
        }
    }
}