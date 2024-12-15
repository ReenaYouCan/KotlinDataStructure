package recursion

fun main() {
    val input = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    val twoDArrayRecursion = TwoDArrayRecursion()
    val visited = Array(input.size) { BooleanArray(input[0].size) }

    println(twoDArrayRecursion.search(input, 5, visited))
}

class TwoDArrayRecursion {

    fun search(grid: Array<IntArray>, num: Int, visited: Array<BooleanArray>): Boolean {

        for (row in grid.indices) {
            for (col in grid[row].indices) {
                if (dfs(row, col, grid, num, visited)) return true
            }
        }

        return false
    }

    fun dfs(row: Int, col: Int, grid: Array<IntArray>, target: Int, visited: Array<BooleanArray>): Boolean {
        if (!isValid(row, col, grid) || visited[row][col])
            return false

        if (grid[row][col] == target)
            return true

        visited[row][col] = true
        //Keep checking in four directions
        for (dir in directions) {
            val tempR = dir[0] + row
            val tempC = dir[1] + col

            if (dfs(tempR, tempC, grid, target, visited)) return true
        }

        return false
    }

    private val directions = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))

    private fun isValid(row: Int, col: Int, grid: Array<IntArray>): Boolean {
        val gridR = grid.size
        val gridC = grid[0].size
        return row >= 0 && col >= 0 && row < gridR && col < gridC
    }
}