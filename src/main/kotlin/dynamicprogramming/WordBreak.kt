package dynamicprogramming

fun main(args: Array<String>) {

    val s = "leetcode"
//    val dict = listOf("cats", "dog", "sand", "and", "cat")
    val dict = listOf("leet", "code")
    val wordBreak = WordBreak()
    println(wordBreak.wordBreak(s, dict))
}

class WordBreak {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dictionary = wordDict.toHashSet()
        return helper(0, s, wordDict, dictionary)
    }

    fun helper(start: Int, s: String, wordDict: List<String>, dictionary: MutableSet<String>): Boolean {
        if (start == s.length) {
            return true
        }

        for (end in start + 1 .. s.length) {
            val isWord = helper(end, s, wordDict, dictionary)
            val subS = s.substring(start, end)
            if (dictionary.contains(subS) && isWord)
                return true
        }

        return false
    }
}