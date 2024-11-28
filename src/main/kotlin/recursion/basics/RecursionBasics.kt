package recursion.basics

fun main() {

    val recursionBasics = RecursionBasics()
    //Basic Function Calls
    recursionBasics.print1(1)

    // recursion
    recursionBasics.printMe(0)

    //Fib
    println(recursionBasics.fib(5))

    //Factorial
    //println("Factorial->${recursionBasics.factorialTailRec(12)}")

    //Fibbonacci
    println("Fibbonacci->${recursionBasics.fibonacciTailRec(7)}")


}

class RecursionBasics {
    // Basic Function Calling
    fun print1(num: Int) {
        println(num)
        print2(num + 1)
    }

    fun print2(num: Int) {
        println(num)
        print3(num + 1)
    }

    fun print3(num: Int) {
        println(num)
        print4(num + 1)
    }

    fun print4(num: Int) {
        println(num)
        print5(num + 1)
    }

    fun print5(num: Int) {
        println(num)
    }
    // End Basic Functions

    // Entry of recursion

    fun printMe(num: Int) {
        if (num > 5) {
            return
        }

        println("Hi! I am $num")
        printMe(num + 1)
    }

    fun fib(num: Int): Int {
        if (num == 0 || num == 1) return num

        val fibonacci = fib(num - 1) + fib(num - 2)
        return fib(num - 1) + fib(num - 2)
    }

    fun fibonacciTailRec(n: Int, a: Int = 0, b: Int = 1): Int {
        if (n == 0) return a
        return fibonacciTailRec(n - 1, b, a + b)
    }


    fun makeOdd(i: Int, nums: IntArray) {
        if (i >= nums.size)
            return

        if (nums[i] % 2 == 0) {
            nums[i] = nums[i] + 1
        }

        makeOdd(i + 1, nums)
    }

    fun factorialTailRec(n: Int, accumulator: Int = 1): Int {
        if (n == 0) return accumulator

        return factorialTailRec(n - 1, n * accumulator)
    }


}

