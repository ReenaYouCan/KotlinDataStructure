package binarysearch

fun main(args: Array<String>) {
    val max = MaximumTimesComputerCanUseBatteries()
    println(max.maxRunTime(2, intArrayOf(3, 3, 3)))
}

class MaximumTimesComputerCanUseBatteries {
    fun maxRunTime(n: Int, batteries: IntArray): Long {
        var sumPower: Long = 0
        for (power in batteries) sumPower += power.toLong()
        var left: Long = 1
        var right = sumPower / n
        while (left < right) {
            val target = right - (right - left) / 2
            var extra: Long = 0
            for (power in batteries) extra += Math.min(power.toLong(), target)
            if (extra >= (n * target)) left = target else right = target - 1
        }
        return left
    }
}
