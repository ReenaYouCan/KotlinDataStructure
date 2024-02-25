package backtracking

//https://www.youtube.com/watch?v=nC1rbW2YSz0&list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&index=11
fun main(args: Array<String>) {
    val board = Array(4) { BooleanArray(4) }
    println(queens(board, 0))
}

fun totalNQueens(n: Int): Int {
    val board = Array(4) { BooleanArray(4) }

    return queens(board, 0)
}

fun isSafe(board: Array<BooleanArray>, row: Int, col: Int): Boolean {
    // Check vertical row
    for (i in 0 until row) {
        if (board[i][col]) return false
    }
//    // Check Horizontal
//    for (hc in 0 until col) {
//        if (board[row][hc]) return false
//    }

    // Check Diagonal Left
    val maxLeft = Math.min(row, col)
    for (i in 1..maxLeft) {
        if (board[row - i][col - i]) return false
    }

    // Check Diagonal Right
    val maxRight = Math.min(row, board.size - col - 1)
    for (i in 1..maxRight) {
        if (board[row - i][col + i]) return false
    }

    return true
}

// Check in same column
// Check in diagonal
// Horizontal
// Vertical
fun queens(board: Array<BooleanArray>, row: Int): Int {
    // Base Case
    if (row == board.size) {
        displayBoard(board)
        println()
        return 1
    }

    var count = 0
    for (col in board.indices) {      // NxN matrix
        if (isSafe(board, row, col)) {
            board[row][col] = true
            count += queens(board, row + 1)
            board[row][col] = false
        }
    }
    return count
}

fun displayBoard(board: Array<BooleanArray>) {
    for (r in board) {
        for (c in r) {
            if (c) {
                print("Q ")
            } else {
                print("K ")
            }
        }
        println()

    }

}


