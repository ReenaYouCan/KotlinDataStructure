package hashmap

//https://leetcode.com/problems/remove-letter-to-equalize-frequency/
fun main(args: Array<String>) {
    println(RemoveLetterToEqualizeFrequency().equalFrequency("cccaa"))
}

class RemoveLetterToEqualizeFrequency {
    fun equalFrequency(word: String): Boolean {

        val frequency = IntArray(26) { 0 }

        for (ch in word) {
            // convert character to int
            val chIndex = ch - 'a'
            frequency[chIndex]++
        }

        var numberOfUniqueCharacters = 0
        var totalFrequency = 0
        for (i in frequency.indices) {
            if (frequency[i] > 0) {
                totalFrequency += frequency[i]
                numberOfUniqueCharacters++
            }
        }
        return totalFrequency % numberOfUniqueCharacters <= 1
    }
}