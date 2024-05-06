package hashmap


fun main(args: Array<String>) {
    val findWinner = FindWinner()
   val result= findWinner.findWinners(
        arrayOf(intArrayOf(1,3), intArrayOf(2,3), intArrayOf(3,6), intArrayOf(5,6),
            intArrayOf(5,7), intArrayOf(4,5),intArrayOf(4,8),intArrayOf(4,9),intArrayOf(10,4),intArrayOf(10,9))
    )

    println(result)
}
class FindWinner {


    fun findWinners(matches: Array<IntArray>): List<List<Int>> {

        val result = MutableList<MutableList<Int>>(2){mutableListOf()}
        // Player andd match result
        // Win Loose
        val countMap = hashMapOf<Int,Match>()


        for(match in matches)
        {
            val winner = match[0]
            val looser = match[1]

            if(countMap.containsKey(winner))
            {
                val pair = countMap[winner]?: Match(0,0)
                val newPair = Match(pair.win+1,pair.loose)
                countMap[winner] = newPair
            } else
            {
                val newPair = Match(0,0)
                countMap[winner] =  newPair
            }


            if(countMap.containsKey(looser))
            {
                val pair = countMap[looser]?: Match(0,0)
                val newPair = Match(pair.win,pair.loose+1)
                countMap[looser] = newPair
            } else
            {
                val newPair = Match(0,0)
                countMap[looser] =  newPair
            }
        }

        countMap.forEach{(k,v)->

            if(v.loose==0)
            {
                result[0].add(k)
            }

            if(v.loose==1)
            {
                result[1].add(k)
            }

        }

        return result
    }

    data class Match(var win:Int,var loose:Int)
}

internal class Solution {
    fun findWinners(matches: Array<IntArray>): List<MutableList<Int>> {
        val answer = MutableList<MutableList<Int>>(2){mutableListOf()}

        val lossesCount: MutableMap<Int, Int> = HashMap()
        for (match in matches) {
            val winner = match[0]
            val loser = match[1]
            lossesCount[winner] = lossesCount.getOrDefault(winner, 0)
            lossesCount[loser] = lossesCount.getOrDefault(loser, 0) + 1
        }
        for (player in lossesCount.keys) if (lossesCount[player] == 0) {
            answer[0].add(player)
        } else if (lossesCount[player] == 1) {
            answer[1].add(player)
        }
        answer[0].sort()
        answer[1].sort()
        return answer
    }

    fun uniqueOccurrences(arr: IntArray): Boolean {
        // Store the frequency of elements in the unordered map.
        val freq: MutableMap<Int, Int> = HashMap()
        for (num in arr) {
            freq[num] = freq.getOrDefault(num, 0) + 1
        }

        // Store the frequency count of elements in the unordered set.
        val freqSet: Set<Int> = HashSet(freq.values)

        // If the set size is equal to the map size,
        // It implies frequency counts are unique.
        return freq.size == freqSet.size
    }
}