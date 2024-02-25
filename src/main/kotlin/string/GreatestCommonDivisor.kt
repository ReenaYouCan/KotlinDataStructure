package string

class GreatestCommonDivisor {
    fun gcdOfStrings(str1: String, str2: String): String {
        val s1 = str1.length
        val s2 = str2.length

        if(str1.equals(str2))
            return str1

        if(s1<s2)
            return gcdOfStrings(str2,str1)

        if(str1.startsWith(str2))
            return gcdOfStrings(str1.substring(str2.length),str2)

        return ""

    }
}