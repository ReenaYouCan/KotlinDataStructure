package string

fun main(args: Array<String>) {
    val repeatedSubstringPattern = RepeatedSubstringPattern()
    println(repeatedSubstringPattern.repeatedSubstringPattern("abab"))
}
class RepeatedSubstringPattern {

    fun repeatedSubstringPattern(s: String): Boolean {
        val n = s.length

        for (i in n / 2 downTo 1) {
            if (n % i == 0) {
                var times = n / i
                val subStr = s.substring(0, i)
                var tempStr = ""
                while (times > 0) {
                    tempStr += subStr
                    times--
                }
                if (tempStr == s)
                    return true
            }
        }
        return false
    }
}