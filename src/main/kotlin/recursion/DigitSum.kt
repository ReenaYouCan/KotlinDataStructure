package recursion

fun main() {

    val digitSum = DigitSum()
    println(digitSum.digitSum(1000001999))
}

class DigitSum {

    fun digitSum(num: Int): Int {
        if (num <= 0) {
            return 0
        }

        val rem = num % 10
        return rem + digitSum(num / 10)
    }

}