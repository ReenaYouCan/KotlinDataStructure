package math

class UglyNumber {

    fun isUgly(n: Int): Boolean {
        var num = n
        while (num > 1) {
            if (num % 2 == 0)
                num /= 2
            else if (num % 3 == 0)
                num /= 3
            else if (num % 5 == 0)
                num /= 5
            else
                return false
        }

        return num == 1
    }


    fun nthUglyNumber(n: Int): Int {
        val arr = Array<Int>(n + 1) { 0 }
        var i2 = 1
        var i3 = 1
        var i5 = 1

        arr[1] = 1

        for (i in 2..n) {
            val i2UglyNum = arr[i2] * 2
            val i3UglyNum = arr[i3] * 3
            val i5UglyNum = arr[i5] * 5

            val minUgly = Math.min(i2UglyNum, Math.min(i3UglyNum, i5UglyNum))
            arr[i] = minUgly

            if (minUgly == i2UglyNum)
                i2++
            if (minUgly == i3UglyNum)
                i3++
            if (minUgly == i5UglyNum)
                i5++
        }

        return arr[n]
    }

    fun compress(chars: CharArray): Int {
        var str = ""

        val n = chars.size

        var i = 0
        var j = 0

        while(i<n)
        {
            val curr = chars[i]
            j = i+1
            var count = 1
            while(j<n && curr==chars[j])
            {
                count++
                j++
            }
            str += "${curr}${count}"
            println(str)
            i = j
        }

        return str.length
    }
}

fun main() {
    val uglyNumber = UglyNumber()
    val result = uglyNumber.compress(charArrayOf('a','b','b','b','b','b','b','b','b','b','b','b','b'))
    println(result)


}