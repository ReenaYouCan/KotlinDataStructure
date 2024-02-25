package binarysearch

fun main(args: Array<String>) {
    val input = arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,60))
    val input1 = arrayOf(intArrayOf(1))
    val searchA2DMatrix = SearchA2DMatrix()
   println(searchA2DMatrix.searchMatrix(input1,1))
}
class SearchA2DMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

        val row = matrix.size
        val col = matrix[0].size

        for (r in 0 until row) {
            var cStart = 0
            var cEnd = col-1

            while (cStart <= cEnd) {
                val mid = (cStart + cEnd) / 2
                if (matrix[r][mid] == target) {
                    return true
                } else if (matrix[r][mid] > target) {
                    cEnd = mid - 1
                } else {
                    cStart = mid + 1
                }
            }
        }

        return false

    }

}