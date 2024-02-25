package array

fun main(args: Array<String>) {
    val productOArrayExceptSelf = ProductOArrayExceptSelf()
    println()
    val product = productOArrayExceptSelf.productExceptSelf(intArrayOf(1, 2, 3, 4))
    for (num in product) {
        println(num)
    }
}

class ProductOArrayExceptSelf {
    fun productExceptSelf(nums: IntArray): IntArray {
        val answer = IntArray(nums.size)
        var right = 1
        answer[0] = 1
        for (i in 1 until nums.size) {
            answer[i] = answer[i - 1] * nums[i-1]
        }


        for (i in nums.size - 1 downTo 0) {
            answer[i] = answer[i] * right
            right = right * nums[i]
        }
        return answer
    }

}