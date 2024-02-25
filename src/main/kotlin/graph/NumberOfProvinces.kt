package graph


//https://leetcode.com/problems/number-of-provinces/description/?envType=study-plan-v2&envId=leetcode-75
class NumberOfProvinces {

    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val directions = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
        val row = isConnected.size
        val col = isConnected[0].size
        val visited = Array(row) { BooleanArray(col) { false } }
        var noOfConnectedCities = 0
        for (r in 0 until row) {
            for (c in 0 until col) {
                if (!visited[r][c] && isConnected[r][c] == 1) {
                    noOfConnectedCities++
                    dfs(r, c, isConnected, visited, directions)
                }
            }
        }

        return noOfConnectedCities
    }


    fun dfs(r: Int, c: Int, isConnected: Array<IntArray>, visited: Array<BooleanArray>, directions: Array<IntArray>) {
        val row = isConnected.size
        val col = isConnected[0].size

        if (r >= row || c >= col || r < 0 || c < 0 || visited[r][c]) {
            return
        }

        for (dir in directions) {
            val nextR = dir[0]
            val nextC = dir[1]
            dfs(nextR, nextC, isConnected, visited, directions)
        }

    }



}