package trees

import trees.nodes.TrieNode

fun main(args: Array<String>) {
    val s = "catsandog"
    val dict = listOf("cats", "dog", "sand", "and", "cat")
//    val dict = listOf("leet", "code")
    val wordBreak = WordBreak()
    println(wordBreak.wordBreak(s, dict))
}

class WordBreak {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val root = TrieNode() // Root with no children initially
        //leet , code

        insertInToTrie(root, wordDict)

        val dp = BooleanArray(s.length)

        for (i in s.indices) {
            if (i == 0 || dp[i - 1]) {
                var curr: TrieNode = root

                for (j in i until s.length) {
                    val char = s[j]
                    if (!curr.children.containsKey(char)) {
                        // no word exists
                        break
                    }
                    curr = curr.children[char]!!
                    if (curr.isWord) {
                        dp[j] = true
                    }
                }
            }
        }

        return dp[s.length - 1]
    }

    private fun insertInToTrie(root: TrieNode, wordDict: List<String>) {
        for (word in wordDict) {
            var curr: TrieNode? = root
            for (char in word) {
                // check if curr node's children contains key
                if (!curr!!.children.containsKey(char)) {
                    curr.children[char] = TrieNode() // Assign Empty TriNode
                }
                curr = curr.children[char] // Put Character tree node to current
            }
            curr!!.isWord = true
        }
    }
}