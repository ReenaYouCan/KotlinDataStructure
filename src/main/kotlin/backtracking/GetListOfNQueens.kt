package backtracking

//https://www.youtube.com/watch?v=nC1rbW2YSz0&list=PL9gnSGHSqcnp39cTyB1dTZ2pJ04Xmdrod&index=11
fun main(args: Array<String>) {
    val board = Array(4) { BooleanArray(4) }
//    println(queens(board, 0))
    val getListOfNQueens = GetListOfNQueens()
//    val result =
        getListOfNQueens.solveNQueens(1)
//    for (row in result) {
//        for (col in row) {
//            print(col)
//        }
//        println()
//    }
}

class GetListOfNQueens {
    fun solveNQueens(n: Int): List<List<String>> {
        val board = Array(n) { BooleanArray(n) }
        return queens(board, 0)
    }


    /**
     * We first create a ( n X n ) chess board and assign 0 to every index.
     * Whenever a queen will be placed, index will be made 1.
     *
     * In this approach ,
     *
     * Whenever a queen is placed, at first it is checked if it satisfies the conditions given that it is not under attack.
     *
     * validMove function.
     * First it check there are no other queen in row the queen is filled.
     * As we are putting queen column wise so no need to check for column.
     * Then there are two diagonals to check for.
     *
     * COLUMN_WISE FILLING = Only left part of the diagonals are checked as positions to the right of the present column are still unfilled.
     * ROW_WISE FILLING = Only upper part of the diagonals are checked as positions below of the present column are still unfilled.
     * If conditions satisfied, Queen is placed and we move to next column.
     * If no queen satisfy the problem, we backtrack and try to change the position of previous queen.
     */
    fun isQueenSafe(board: Array<BooleanArray>, row: Int, col: Int): Boolean {
        // Check vertical row
        for (i in 0 until row) {
            if (board[i][col]) return false
        }

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
    fun queens(board: Array<BooleanArray>, row: Int): MutableList<MutableList<String>> {
        // Base Case
        if (row == board.size) {
            val listOfStrings = mutableListOf<MutableList<String>>()
            listOfStrings.add(displayBoard(board))
            return listOfStrings
        }

        val allQueens = mutableListOf<MutableList<String>>()
        for (col in board.indices) {      // NxN matrix
            if (isQueenSafe(board, row, col)) {
                board[row][col] = true
                allQueens.addAll(queens(board, row + 1))
                board[row][col] = false
            }
        }
        return allQueens
    }

    fun displayBoard(board: Array<BooleanArray>): MutableList<String> {
        val result = mutableListOf<String>()
        for (r in board) {
            var placeQueen = ""
            for (c in r) {
                if (c) {
                    placeQueen+="Q"
                    // row.add("Q")
                }
                else {
                    placeQueen+="."

                    // row.add(".")
                }
            }
            result.add(placeQueen)
        }
        return result
    }
}

