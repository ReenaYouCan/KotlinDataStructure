package recursion

var reversedNum = 0

fun main() {
    ReverseNumber.reverseNumExternalVar(1234)
//    println(reversedNum)

//    println(ReverseNumber.modifyAndReturnReverseNumber(1234))

//    println(ReverseNumber.countZeros(340000000,0))

//    println(ReverseNumber.numberOfSteps(10))

    println(ReverseNumber.reverseNumExternalVar(89399))
}

object ReverseNumber {


    // External Variable
    fun reverseNumExternalVar(num: Int) {
        if (num % 10 == num) {
            reversedNum = reversedNum * 10 + num
            return
        }

        val reminder = num % 10
        reversedNum = reversedNum * 10 + reminder

        reverseNumExternalVar(num / 10)
    }

    // Returning argument in when reaches to base case
    fun countZeros(num: Int, count: Int): Int {
        if (num == 0) {
            return count
        }

        if (num % 10 == 0) {
           return countZeros(num/10, count+1)
        } else {
          return  countZeros(num/10, count)
        }
    }

    fun numberOfSteps(num: Int): Int {
        return helper(num,0)
    }

    fun helper(num: Int, steps: Int): Int
    {
        if(num==0)
            return steps

        if(num%2==0)
        {
            return helper(num/2,steps+1)
        }

        return helper(num-1,steps+1)
    }

}