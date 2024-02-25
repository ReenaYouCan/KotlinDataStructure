package backtracking

fun main(args: Array<String>) {

//    println(printPaths(3, 3, ""))
    val output = returnDiagonalPathsArrayList(3, 3, "")

//    printPathsArrayList(3, 3, "", output)

//    for (path in output) {
//        println(path)
//    }

//    println("-------")
//    println(output)

    val maze = arrayOf(
        booleanArrayOf(true, true, true),
        booleanArrayOf(true, false, true),
        booleanArrayOf(true, true, true)
    )

    println(printPathsWithObstacle(0, 0, "", maze))

}

// Here we are returning count once satisfy base condition
fun countPaths(r: Int, c: Int): Int {

    if (r == 1 || c == 1) {
        return 1
    }

    val down = countPaths(r - 1, c)
    val right = countPaths(r, c - 1)

    return down + right
}

// Here we are printing paths
fun printPaths(r: Int, c: Int, path: String) {

    if (r < 0 || c < 0)
        return

    if (r == 1 && c == 1) {
        println(path)
        return
    }

    printPaths(r - 1, c, path + "D")
    printPaths(r, c - 1, path + "R")


}

// Add path in arraylist
fun printPathsArrayList(r: Int, c: Int, path: String, output: MutableList<String>) {

    if (r < 0 || c < 0)
        return

    if (r == 1 && c == 1) {
        output.add(path)
        println(path)
        return
    }

    if (r > 1) {
        printPaths(r - 1, c, path + "D")
    }
    if (c > 1) {
        printPaths(r, c - 1, path + "R")
    }

}


// Add path in arraylist
fun returnPathsArrayList(r: Int, c: Int, path: String): MutableList<String> {

    if (r == 1 && c == 1) {
        val list = mutableListOf<String>()
        list.add(path)
        return list
    }

    var result = mutableListOf<String>()

    if (r > 1) {
        result.addAll(returnPathsArrayList(r - 1, c, path + "D"))
    }
    if (c > 1) {
        result.addAll(returnPathsArrayList(r, c - 1, path + "R"))
    }

    return result
}

// Add path in arraylist
/**
 * C = Corner->>> Diagonal
 * D = Down
 * R = Right
 */
fun returnDiagonalPathsArrayList(r: Int, c: Int, path: String): MutableList<String> {

    if (r == 1 && c == 1) {
        val list = mutableListOf<String>()
        list.add(path)
        return list
    }

    val result = mutableListOf<String>()

    if (r > 1 && c > 1) {
        result.addAll(returnDiagonalPathsArrayList(r - 1, c - 1, path + "C"))
    }
    if (r > 1) {
        result.addAll(returnDiagonalPathsArrayList(r - 1, c, path + "D"))
    }
    if (c > 1) {
        result.addAll(returnDiagonalPathsArrayList(r, c - 1, path + "R"))
    }

    return result
}


// Here we are printing paths
fun printPathsWithObstacle(r: Int, c: Int, path: String, maze: Array<BooleanArray>) {
    val row = maze.size
    val col = maze[0].size


    if (r > row - 1 || c > col - 1)
        return

    if (r == row - 1 && c == col - 1) {
        println(path)
        return
    }

    if (!maze[r][c]) return

    printPathsWithObstacle(r + 1, c, path + "D",maze)
    printPathsWithObstacle(r, c + 1, path + "R",maze)

}