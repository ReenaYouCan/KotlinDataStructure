package graph

fun main(args: Array<String>) {
    val input =
        arrayOf(charArrayOf('+', '+', '.', '+'), charArrayOf('.', '.', '.', '+'), charArrayOf('+', '+', '+', '.'))
    val nearestExitFromEntranceMaze = NearestExitFromEntranceMaze()
    println(nearestExitFromEntranceMaze.nearestExit(input, intArrayOf(1, 2)))
}

class NearestExitFromEntranceMaze {
    val directions = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(0, -1)
    )


    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val visited = Array(maze.size) { BooleanArray(maze[0].size) { false } }

        return dfs(maze, entrance[0], entrance[1], 0, visited, entrance)
    }

    fun dfs(
        maze: Array<CharArray>,
        row: Int,
        col: Int,
        path: Int,
        visited: Array<BooleanArray>,
        entrance: IntArray
    ): Int {
        val isEntrance = row != entrance[0] && col != entrance[1]
        if (!isEntrance && isOnBorder(row, col, maze.size, maze[0].size))
            return path

        if (maze[row][col] == '+' || visited[row][col])
            return Integer.MAX_VALUE

        visited[row][col] = true

        var ans = Integer.MAX_VALUE
        for (dir in directions) {
            val currR = row + dir[0]
            val currC = col + dir[1]
            if (!visited[currR][currC] && insideMaze(
                    currR,
                    currC,
                    maze.size,
                    maze[0].size
                ) && maze[currR][currC] == '.'
            ) {
                ans = Math.min(ans, dfs(maze, currR, currC, path + 1, visited, entrance))
            }
        }

        return if (ans == Integer.MAX_VALUE) -1 else ans
    }

    private fun insideMaze(row: Int, col: Int, m: Int, n: Int): Boolean {
        return row >= 0 && row < m && col >= 0 && col < n
    }

    private fun isOnBorder(row: Int, col: Int, m: Int, n: Int): Boolean {
        return row == 0 || row == m - 1 || col == 0 || col == n - 1
    }
}
