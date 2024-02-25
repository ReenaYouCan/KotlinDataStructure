package dynamicprogramming

import java.util.*


class SmallestSufficientTeam {
    internal class Solution {
        var n = 0
        lateinit var skillsMaskOfPerson: IntArray
        lateinit var dp: LongArray
        private fun f(skillsMask: Int): Long {
            if (skillsMask == 0) {
                return 0L
            }
            if (dp[skillsMask] != -1L) {
                return dp[skillsMask]
            }
            for (i in 0 until n) {
                val smallerSkillsMask = skillsMask and skillsMaskOfPerson[i].inv()
                if (smallerSkillsMask != skillsMask) {
                    val peopleMask = f(smallerSkillsMask) or (1L shl i)
                    if (dp[skillsMask] == -1L || java.lang.Long.bitCount(peopleMask) <
                        java.lang.Long.bitCount(dp[skillsMask])
                    ) {
                        dp[skillsMask] = peopleMask
                    }
                }
            }
            return dp[skillsMask]
        }

        fun smallestSufficientTeam(req_skills: Array<String>, people: List<List<String>>): IntArray {
            n = people.size
            val m = req_skills.size
            val skillId = HashMap<String, Int>()
            for (i in 0 until m) {
                skillId[req_skills[i]] = i
            }
            skillsMaskOfPerson = IntArray(n)
            for (i in 0 until n) {
                for (skill in people[i]) {
                    skillsMaskOfPerson[i] = skillsMaskOfPerson[i] or (1 shl skillId[skill]!!)
                }
            }
            dp = LongArray(1 shl m)
            Arrays.fill(dp, -1)
            val answerMask = f((1 shl m) - 1)
            val ans = IntArray(java.lang.Long.bitCount(answerMask))
            var ptr = 0
            for (i in 0 until n) {
                if (answerMask shr i and 1L == 1L) {
                    ans[ptr++] = i
                }
            }
            return ans
        }
    }
}