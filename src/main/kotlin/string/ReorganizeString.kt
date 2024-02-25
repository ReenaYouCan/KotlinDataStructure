package string

import java.util.*


class ReorganizeString {
    internal class Solution {
        fun reorganizeString(s: String): String {
            val charCounts = IntArray(26)
            for (c in s.toCharArray()) {
                charCounts[c.code - 'a'.code] = charCounts[c.code - 'a'.code] + 1
            }

            // Max heap ordered by character counts
            val pq = PriorityQueue { a: IntArray, b: IntArray ->
                Integer.compare(
                    b[1],
                    a[1]
                )
            }
            for (i in 0..25) {
                if (charCounts[i] > 0) {
                    pq.offer(intArrayOf(i + 'a'.code, charCounts[i]))
                }
            }
            val sb = StringBuilder()
            while (!pq.isEmpty()) {
                val first = pq.poll()
                if (sb.length == 0 || first[0] != sb[sb.length - 1].code) {
                    sb.append(first[0].toChar())
                    if (--first[1] > 0) {
                        pq.offer(first)
                    }
                } else {
                    if (pq.isEmpty()) {
                        return ""
                    }
                    val second = pq.poll()
                    sb.append(second[0].toChar())
                    if (--second[1] > 0) {
                        pq.offer(second)
                    }
                    pq.offer(first)
                }
            }
            return sb.toString()
        }
    }
}