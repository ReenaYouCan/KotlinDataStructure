package graph


//https://leetcode.com/problems/number-of-provinces/description/?envType=study-plan-v2&envId=leetcode-75
class NumberOfProvincesCorrect {

    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val n = isConnected.size
        var noOfProvinces = 0
        val visited = BooleanArray(n) { false }
        for (i in 0 until n) {
            if (!visited[i]) {
                dfs(i, isConnected, visited)
                noOfProvinces++

            }
        }
        return noOfProvinces
    }


    fun dfs(u: Int, isConnected: Array<IntArray>, visited: BooleanArray) {

        visited[u] = true

        for (v in isConnected.indices) {
            if (!visited[v] && isConnected[u][v] == 1) {
                dfs(v, isConnected, visited)
            }
        }
    }


}