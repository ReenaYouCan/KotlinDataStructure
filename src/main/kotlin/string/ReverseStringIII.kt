package string

fun main(args: Array<String>) {
val reverseStringIII = ReverseStringIII()
    println(reverseStringIII.reverseWords("Let's take LeetCode contest"))

}

class ReverseStringIII {
    fun reverseWords(s: String): String {
        //split string with spaces
        //ArrayOf String
        //reverse each string from array
        //build the string template


        val stringArray = s.split(" ").toMutableList()

        var result :String = ""
        stringArray.forEach { it -> reverseString(it).also { result = "$result $it" } }

        return result.removePrefix(" ")
    }


    fun reverseString(s: String): String {
        val n = s.length
        val charArray = s.toCharArray()
        for (i in 0 until n / 2) {

            val temp = charArray[i]
            charArray[i] = charArray[n - i - 1]
            charArray[n - i - 1] = temp
        }

        val colors = "ABBBBBBBAAA"
        colors.contains("AAA")

        return String(charArray)
    }
}