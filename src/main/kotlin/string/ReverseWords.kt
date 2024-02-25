package string

import java.lang.StringBuilder

fun main(args: Array<String>) {
    val reverseWords = ReverseWords()
    println(reverseWords.reverseWords("  hello world  "))
}

class ReverseWords {
    fun reverseWords(s: String): String {
        val sToCharArray = s.split(' ').toMutableList()

        var left = 0
        var right = sToCharArray.size - 1

        while (left < right) {
            val temp = sToCharArray[left]
            sToCharArray[left] = sToCharArray[right]
            sToCharArray[right] = temp
            left++
            right--
        }

        val sb = StringBuilder()
        for (str in sToCharArray) {
            if(!str.equals("")) {
                sb.append(str)
                sb.append(" ")
            }
        }
        return sb.toString().removeSuffix(" ")
    }
}