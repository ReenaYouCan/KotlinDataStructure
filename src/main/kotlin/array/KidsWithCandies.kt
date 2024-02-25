package array

class KidsWithCandies {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {

        val result = MutableList(candies.size) { false }

        val max = getMax(candies)

        for(candy in candies.indices)
        {
            val maxCandies = extraCandies + candies[candy]
            if(maxCandies>=max)
            {
                result[candy] = true
            }
        }
        return result
    }

    fun getMax(candies: IntArray):Int
    {
        var max = candies[0]
        for(i in 1 until candies.size)
        {
            max = Math.max(max,candies[i])
        }
        return max
    }

}

val outout = IntArray(9){0}

