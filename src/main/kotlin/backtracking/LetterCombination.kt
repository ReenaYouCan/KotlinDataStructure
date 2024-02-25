package backtracking

/**
 * 17. Letter Combinations of a Phone Number
 * Medium
 * 15.5K
 * 853
 * Companies
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 *
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 *
 * Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 *
 */
fun main(args: Array<String>) {
    val classCombination = LetterCombination()
    println(classCombination.letterCombinations("23"))
}

class LetterCombination {

    val lettersMap = mutableMapOf(
        '1' to "",
        '2' to "abc",
        '3' to "def",
        '4' to "ghi",
        '5' to "jkl",
        '6' to "mno",
        '7' to "pqrs",
        '8' to "tuv",
        '9' to "wxyz"
    )

    // Return List of combinations
    fun letterCombinations(digits: String): List<String> {
        return helper(0, digits, "", lettersMap)
    }

    fun helper(index: Int, digits: String, result: String, lettersMap: Map<Char, String>): List<String> {
        val list = mutableListOf<String>()
        if (digits.isEmpty())
            return list

        if (result.length == digits.length) {
            list.add(result)
            return list
        }

        val resultList = mutableListOf<String>()
        val letters = lettersMap[digits[index]]

        for (ch in letters!!) {
            resultList.addAll(helper(index + 1, digits, result + ch, lettersMap))
        }
        return resultList
    }

}