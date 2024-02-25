package trees

import java.util.*


// Custom class Trie with function to get 3 words starting with given prefix
internal class Trie {
    // Node definition of a trie
    internal inner class Node {
        var isWord = false
        var children = Arrays.asList(*arrayOfNulls<Node>(26))
    }

    var Root: Node
    var curr: Node? = null
    var resultBuffer: MutableList<String>? = null

    // Runs a DFS on trie starting with given prefix and adds all the words in the resultBuffer, limiting result size to 3
    fun dfsWithPrefix(curr: Node?, word: String) {
        if (resultBuffer!!.size == 3) return
        if (curr!!.isWord) resultBuffer!!.add(word)

        // Run DFS on all possible paths.
        var c = 'a'
        while (c <= 'z') {
            if (curr.children[c.toByte().toInt() - 'a'.toByte().toInt()] != null) dfsWithPrefix(curr.children[c.toByte().toInt() - 'a'.toByte().toInt()], word + c)
            c++
        }
    }

    init {
        Root = Node()
    }

    // Inserts the string in trie.
    fun insert(s: String) {

        // Points curr to the root of trie.
        curr = Root
        for (c in s.toCharArray()) {
            if (curr!!.children[c.toByte().toInt() - 'a'.toByte().toInt()] == null) curr!!.children[c.toByte().toInt() - 'a'.toByte().toInt()] = Node()
            curr = curr!!.children[c.toByte().toInt() - 'a'.toByte().toInt()]
        }

        // Mark this node as a completed word.
        curr!!.isWord = true
    }

    fun getWordsStartingWith(prefix: String): List<String> {
        curr = Root
        resultBuffer = ArrayList<String>()
        // Move curr to the end of prefix in its trie representation.
        for (c in prefix.toCharArray()) {
            if (curr!!.children[c.toByte().toInt() - 'a'.toByte().toInt()] == null) return resultBuffer as ArrayList<String>
            curr = curr!!.children[c.toByte().toInt() - 'a'.toByte().toInt()]
        }
        dfsWithPrefix(curr, prefix)
        return resultBuffer as ArrayList<String>
    }
};
internal class Solution {
    fun suggestedProducts(
        products: Array<String>,
        searchWord: String
    ): List<List<String>> {
        val trie = Trie()
        val result: MutableList<List<String>> = ArrayList()
        // Add all words to trie.
        for (w in products) trie.insert(w)
        var prefix = String()
        for (c in searchWord.toCharArray()) {
            prefix += c
            result.add(trie.getWordsStartingWith(prefix))
        }
        return result
    }
}