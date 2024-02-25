package graph.bfs

import java.util.*

class NoOfIsland {
    fun numIslands(grid: Array<CharArray>): Int {
        // This is not a graph problem keep that in mind this problem is based on 2D array searching
        // This problem can be solved using B
        var visited = Array(grid.size){BooleanArray(grid[0].size){false}}

        val m = grid.size
        val n = grid[0].size

        var noOfIslands = 0

        for(row in 0 until m)
        {
            for(col in 0 until n)
            {
                if(!visited[row][col] && grid[row][col]=='1')
                {
                    bfs(row,col,m,n,grid,visited)
                    noOfIslands++
                }
            }
        }




        return noOfIslands
    }

    fun bfs(row:Int,col:Int,m:Int,n:Int,grid: Array<CharArray>,visited:Array<BooleanArray>)
    {

        // Initiate Queue to hold the land co-ordinates
        val queue : Queue<Pair<Int,Int>> = LinkedList()

        queue.add(Pair(row,col))

        while(queue.isNotEmpty())
        {
            val land = queue.poll()
            visited[land.first][land.second] = true
            // Exploring its neighbours
            directions.forEach{ dir->
                val r = dir[0] + land.first
                val c = dir[1] + land.second
                if(isValid(r,c,m,n,grid,visited))
                {
                    queue.add(Pair(r,c))
                }
            }
            // From this land we are going to explore other lands in four directions
        }

    }

    val directions = arrayOf(intArrayOf(1,0),intArrayOf(-1,0),intArrayOf(0,-1),intArrayOf(0,1))

    fun isValid(row:Int,col:Int,m:Int,n:Int,grid:Array<CharArray>,visited:Array<BooleanArray>) : Boolean
    {
        return row in 0 until m && col in 0 until n && grid[row][col]=='1' && !visited[row][col]

    }
}