package string

fun main(args: Array<String>) {

    val findTheDifferences = FindTheDifferences().findTheDifference("qaz","qazw")
    println(findTheDifferences)
}

class FindTheDifferences {
    // Lets make use of XOR operation
//    fun findTheDifference(s: String, t: String): Char {
//        var i = 0
//        var j = 0
//        var charNum = 0
//
//        while (i < s.length && j < t.length) {
//            val charS = s[i]
//            val charT = t[j]
//            charNum += charS xor charT
//            i++
//            j++
//        }
//
//        charNum  = charNum xor t[j] - 'a'
//
//        return charNum.toChar()
//    }

    fun findTheDifference(s: String, t: String): Char {

        // Initialize ch with 0, because 0 ^ X = X
        // 0 when XORed with any bit would not change the bits value.
        var ch = 0.toChar()

        // XOR all the characters of both s and t.
        run {
            var i = 0
            while (i < s.length) {
                ch = (ch.code xor s[i].code).toChar()
                i += 1
            }
        }
        var i = 0
        while (i < t.length) {
            ch = (ch.code xor t[i].code).toChar()
            i += 1
        }

        // What is left after XORing everything is the difference.
        return ch
    }

    //s = "abcd"
    //t = "abcde"

    //s = "shona"
    //t = "nashor"

    // num += s ^ n
    //


    // convert char to int


}