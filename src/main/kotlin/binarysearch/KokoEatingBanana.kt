package binarysearch

// piles of bananas
// koko has h hours to finish all the bananas
// Koko needs to decide her per hour banana eating speed k
// if pile has bananas < k then she just eats all the banana
// She wants to finish all the bananas
// we need to find a k such that she can finish all the bananas within h hours

class KokoEatingBanana {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        // We need to find the maximum number to get the range to find a k, k should lies within 1 to max num

        var right = piles.max()
        var left = 1

        // We need to find minimum
        while (left < right) {

            val mid = left + (right - left) / 2

            if (isPossible(piles, mid, h)) {
                right = mid
            } else {
                left = mid + 1
            }
        }

        return left
    }


    fun isPossible(piles: IntArray, k: Int, h: Int): Boolean {
        //total time required to each all the banana;s for given k
        var totalRequiredTime = 0

        for (i in piles.indices) {
            val div = piles[i] / k
            val rem = piles[i] % k

            totalRequiredTime += div

            if (rem != 0) {
                totalRequiredTime++
            }
        }


        return totalRequiredTime <= h
    }
}