package bit


fun main(args: Array<String>) {
    println(singleNumber(intArrayOf(4,4,4,2,2,2,1,1,1,3)))
}
fun singleNumber(nums: IntArray): Int {
    var one = 0
    var two = 0
    for (num in nums) {
        one = (one xor num) and two.inv()
        two = (two xor num) and one.inv()
    }
    return one
}