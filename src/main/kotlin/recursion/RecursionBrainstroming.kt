package recursion

fun main() {
    val addNumbers = AddNumbers()
    println("Sum of Nums ${addNumbers.addNums(arrayOf(1, 2, 3, 4, 5), 0)}")
    println("Reversed Array${addNumbers.printNumsInReverseOrder(arrayOf(1, 2, 3, 4, 5), 0)}")

}

class AddNumbers {


    fun addNums(numbers: Array<Int>, i: Int, sum: Int): Int {
        if (i >= numbers.size)
            return sum

        return addNums(numbers, i + 1, sum + numbers[i])

    }

    var sum = 0

    fun addNums(numbers: Array<Int>, i: Int) {
        if (i >= numbers.size) return

        sum += numbers[i]
        addNums(numbers, i + 1)

    }

    fun printNumsInReverseOrder(numbers: Array<Int>, i: Int)
    {
        if(i>=numbers.size)
            return

        printNumsInReverseOrder(numbers, i+1)
        println(numbers[i])
    }
}