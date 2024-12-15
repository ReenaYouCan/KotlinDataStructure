package recursion

fun main() {
    val digitProduct = DigitProduct()
    println(digitProduct.digitProduct(125))
}

class DigitProduct {
    fun digitProduct(num: Int) : Int {
        if (num%10 == num) {
            return num
        }

        val rem = num % 10
        return rem * digitProduct(num / 10)
    }
}