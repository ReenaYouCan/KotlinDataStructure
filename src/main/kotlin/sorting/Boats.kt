package sorting

import java.util.Arrays

fun main() {
    val boats = Boats()
    println("Boats:" + boats.numRescueBoats(intArrayOf(5, 1, 4, 2), 6))
}

class Boats {
    fun numRescueBoats(people: IntArray, limit: Int): Int {

        Arrays.sort(people)
        var i = 0
        var boat = 0

        while (i < people.size) {
            // value would be less than or equal to limit
            val curr = people[i]
            if (curr == limit) {
                boat++
                i++
            } else
                if (curr < limit) {
                    var sum = curr
                    if (i < people.size - 1) {
                        sum += people[i + 1]
                    }
                    if (sum <= limit) {
                        boat++
                        i += 2
                    } else {
                        boat++
                        i++
                    }
                }
        }

        return boat
    }
}