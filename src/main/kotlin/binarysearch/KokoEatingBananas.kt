package binarysearch

fun main(args: Array<String>) {
    val kokoEatingBananas = KokoEatingBananas()
    println(kokoEatingBananas.minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 5))
}

class KokoEatingBananas {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {

        var left = 1
        var right = getMax(piles)
        var result: Int = 1
        // need to get maximum from array

        while (left < right) {

            val mid = left + (right - left) / 2
            if (canEatAllBananas(piles, h, mid)) {
                result = mid
                right = mid
            } else {
                left = mid + 1
            }

        }


        return left
    }

    fun getMax(piles: IntArray): Int {
        var max = piles[0]
        for (i in 1 until piles.size) {
            max = Math.max(piles[i], max)
        }

        return max
    }

    fun canEatAllBananas(piles: IntArray, h: Int, n: Int): Boolean {
        var totalTime = 0

        for (i in 0 until piles.size) {
            val div = piles[i] / n
            val rem = piles[i] % n

            totalTime += div
            if (rem != 0) {
                totalTime++
            }

        }


        piles.sum()
        return totalTime <= h
    }
}