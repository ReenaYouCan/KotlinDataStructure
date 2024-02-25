package hashmap

import java.util.concurrent.ConcurrentMap

fun main(args: Array<String>) {
    val minimumDeletionOfCharacters = MinimumDeletionOfCharacters()
    println(minimumDeletionOfCharacters.minDeletions("ceabaacb"))
}
class MinimumDeletionOfCharacters {
    fun minDeletions(s: String): Int {
        // Store Frequency of character
        // Lets check hashmap gives us the chance to find value -> yes it does

        val frequencyMap  = mutableMapOf<Char,Int>()
        val uniqueFrequency = mutableSetOf<Int>()
        var result = 0
        for(ch in s)
        {
            frequencyMap.computeIfAbsent(ch){0} // Initialize to zero
            frequencyMap[ch] = frequencyMap[ch]!! + 1 // Increment the frequency
        }

        frequencyMap.forEach{(k,v)->
            // Need to check if we get most recent value or not
            val value = frequencyMap[k]
            var tempValue = value
            while(uniqueFrequency.contains(tempValue) && tempValue!!>0)
            {
                // reduce the frequency by one of current character and store it back to both set and hashmap
                frequencyMap.compute(k) { _, currentCount -> currentCount?.minus(1) }
                tempValue -= 1
                result++
            }
            uniqueFrequency.add(frequencyMap[k]!!)
        }


        return result
    }
}