package string

class ReverseVowelsString {
    fun reverseVowels(s: String): String {
        var start = 0
        var end = s.length - 1

        val sCharArray = s.toCharArray()
        while (start < end) {

            // Find the leftmost vowel
            while (start < s.length && !isVowel(sCharArray[start])) {
                start++;
            }
            // Find the rightmost vowel
            while (end >= 0 && !isVowel(sCharArray[end])) {
                end--;
            }

            if (start<end) {
                val temp = sCharArray[start]
                sCharArray[start] = sCharArray[end]
                sCharArray[end] = temp
                start++
                end++
            }
        }

        return sCharArray.toString()
    }


    fun isVowel(c: Char): Boolean {
        return c == 'a' || c == 'i' || c == 'e' || c == 'o' || c == 'u' || c == 'A' || c == 'I' || c == 'E' || c == 'O' || c == 'U'
    }
}