package dynamicprogramming

class MinACSIIDeleteSum {
    var m: Int = 0
    var n: Int = 0

    fun minimumDeleteSum(s1: String, s2: String): Int {
        m = s1.length
        n = s2.length
        return helper(0, 0, s1, s2)
    }

    fun helper(i: Int, j: Int, s1: String, s2: String): Int {

        //If both strings are exhausted
        if (i >= m && j >= n)
            return 0

        //If s1 is empty
        if (i >= m)
            return s1[i].toByte().toInt() + helper(i + 1, j, s1, s2)

        //If s2 is
        if (i >= n)
            return s2[i].toByte().toInt() + helper(i, j + 1, s1, s2)

        if (s1[i] == s2[i])
            return helper(i + 1, j + 1, s1, s2)

        val delete_s1_i = s1[i].toByte().toInt() + helper(i + 1, j, s1, s2)
        val delete_s2_i = s2[i].toByte().toInt() + helper(i, j + 1, s1, s2)

        return Math.min(delete_s1_i, delete_s2_i)

    }
}

