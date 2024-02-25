package backtracking

import java.util.*


fun main(args: Array<String>) {

    val maze = arrayOf(
        booleanArrayOf(true, true, true),
        booleanArrayOf(true, true, true),
        booleanArrayOf(true, true, true)
    )

    val paths = Array(maze.size) { IntArray(maze[0].size) { 0 } }

    printAllPathsInGrid(0, 0, "", maze, paths, 1)


}

fun printAllPaths(r: Int, c: Int, path: String, maze: Array<BooleanArray>) {
    val row = maze.size
    val col = maze[0].size


    if (r > row - 1 || c > col - 1 || c < 0 || r < 0 || !maze[r][c])
        return

    if (r == row - 1 && c == col - 1) {
        println(path)
        return
    }

//    if (!maze[r][c]) return

    maze[r][c] = false

    printAllPaths(r + 1, c, path + "D", maze)

    printAllPaths(r, c + 1, path + "R", maze)
    printAllPaths(r, c - 1, path + "L", maze)
    printAllPaths(r - 1, c, path + "U", maze)

    maze[r][c] = true

}

fun printAllPathsInGrid(r: Int, c: Int, path: String, maze: Array<BooleanArray>, paths: Array<IntArray>, level: Int) {
    val row = maze.size
    val col = maze[0].size


    if (r > row - 1 || c > col - 1 || c < 0 || r < 0 || !maze[r][c])
        return

    if (r == row - 1 && c == col - 1) {
        paths[r][c] = level
        for (arr in paths) {
            println(arr.contentToString())
        }
        println(path)
        return
    }

//    if (!maze[r][c]) return

    maze[r][c] = false
    paths[r][c] = level
    // ONce you done all the operations for tha call you need to reset the value to backtrack
    printAllPathsInGrid(r + 1, c, path + "D", maze, paths, level + 1)
    printAllPathsInGrid(r, c + 1, path + "R", maze, paths, level + 1)
    printAllPathsInGrid(r, c - 1, path + "L", maze, paths, level + 1)
    printAllPathsInGrid(r - 1, c, path + "U", maze, paths, level + 1)
    maze[r][c] = true
    paths[r][c] = 0


}