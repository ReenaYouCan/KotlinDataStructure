package slidingwindow

import java.util.*


/**
 * A teacher is writing a test with n true/false questions, with 'T' denoting true and 'F' denoting false. He wants to confuse the students by maximizing the number of consecutive questions with the same answer (multiple trues or multiple falses in a row).
 *
 * You are given a string answerKey, where answerKey[i] is the original answer to the ith question. In addition, you are given an integer k, the maximum number of times you may perform the following operation:
 *
 * Change the answer key for any question to 'T' or 'F' (i.e., set answerKey[i] to 'T' or 'F').
 * Return the maximum number of consecutive 'T's or 'F's in the answer key after performing the operation at most k times.
 *
 *
 *
 * Example 1:
 *
 * Input: answerKey = "TTFF", k = 2
 * Output: 4
 * Explanation: We can replace both the 'F's with 'T's to make answerKey = "TTTT".
 * There are four consecutive 'T's.
 * Example 2:
 *
 * Input: answerKey = "TFFT", k = 1
 * Output: 3
 * Explanation: We can replace the first 'T' with an 'F' to make answerKey = "FFFT".
 * Alternatively, we can replace the second 'T' with an 'F' to make answerKey = "TFFF".
 * In both cases, there are three consecutive 'F's.
 * Example 3:
 *
 * Input: answerKey = "TTFTTFTT", k = 1
 * Output: 5
 * Explanation: We can replace the first 'F' to make answerKey = "TTTTTFTT"
 * Alternatively, we can replace the second 'F' to make answerKey = "TTFTTTTT".
 * In both cases, there are five consecutive 'T's.
 *
 *
 * Constraints:
 *
 * n == answerKey.length
 * 1 <= n <= 5 * 104
 * answerKey[i] is either 'T' or 'F'
 * 1 <= k <= n
 *
 */

/**
 * Approaches
 *
 * Brute Force
 * We can make a two recursion call to flip and not flip
 * update the maximum answer we get from recusions functions for k TImes
 *
 * This brute force solution throws time limit exceed
 *
 *
 *
 */

class MaximizeConfusionOfAnExam {

    var result = 0
    var currLength = 0
    fun maxConsecutiveAnswersBF(answerKey: String, k: Int): Int {
        solve(0, answerKey.toCharArray(), k)

        return result
    }

    fun solve(index: Int, answerKey: CharArray, k: Int) {
        findMax(answerKey)

        if (index >= answerKey.size || k <= 0) {
            return
        }

        answerKey[index] = if (answerKey[index] == 'T') 'F' else 'T' // flip

        solve(index + 1, answerKey, k - 1)

        answerKey[index] = if (answerKey[index] == 'T') 'F' else 'T' // flipped back

        solve(index + 1, answerKey, k)


    }

    fun findMax(answerKey: CharArray): Int {

        var i = 0
        while (i < answerKey.size) {
            if (answerKey[i] == 'T') {
                currLength = 1
                i++
                while (i < answerKey.size && answerKey[i] == 'T') {
                    currLength++
                    i++
                }
            } else {
                currLength = 1
                i++
                while (i < answerKey.size && answerKey[i] == 'F') {
                    currLength++
                    i++
                }
            }
            result = Math.max(result, currLength)
        }

        return result
    }

    fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
        var result = 0
        val map = mutableMapOf<Char, Int>()
        map['T'] = 0
        map['F'] = 0
        var i = 0
        var j = 0

        while (j < answerKey.length) {

            map.getOrPut(answerKey[j]) { 1 }

            while (Math.min(map['T']!!, map['F']!!) > k) {
                map[answerKey[i]] = map[answerKey[i]]!! - 1
                i++
            }

            result = Math.max(result, j - i + 1)
            j++
        }

        return result

    }
}


//internal class graph.Solution {
//    fun maxConsecutiveAnswers(answerKey: String, k: Int): Int {
//        var maxSize = 0
//        val count: MutableMap<Char, Int> = HashMap()
//        for (right in 0 until answerKey.length) {
//            count[answerKey[right]] = count.getOrDefault(answerKey[right], 0) + 1
//            val minor = Math.min(count.getOrDefault('T', 0), count.getOrDefault('F', 0))
//            if (minor <= k) {
//                maxSize++
//            } else {
//                count[answerKey[right - maxSize]] = count[answerKey[right - maxSize]]!! - 1
//            }
//        }
//        return maxSize
//    }
//}

fun main(args: Array<String>) {
    val consecutive = MaximizeConfusionOfAnExam()
    println(consecutive.maxConsecutiveAnswers("TFFT", 1))


}