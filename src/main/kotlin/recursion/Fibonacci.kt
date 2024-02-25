package recursion

import java.util.*


fun main(args: Array<String>) {
    val fibonacci = Fibonacci()
    val output = fibonacci.fibonacci(6)
    val output1 = fibonacci.fibonacciW(6)


    println(output)

    fibonacci.countPalindromicSubsequence("lEetcode")
}
class Fibonacci {
    tailrec fun fibonacci(n: Int, a: Long = 0, b: Long = 1): Long {
        return when (n) {
            0 -> a
            1 -> b
            else -> fibonacci(n - 1, b, a + b)
        }
    }

    fun fibonacciW(n: Int, a: Long = 0, b: Long = 1): Long {
        return when (n) {
            0 -> a
            1 -> b
            else -> fibonacciW(n - 1, b, a + b)
        }
    }


    fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
        // Calculate time array by dist/speed
        // Take the result variable to keep track of killed monster
        // Sort the time array so that we can kill the monster as per the erliest arrival
        // Initially result would be 1
        // Gun would be loaded at this point
        // for each time from 1 to n
        // if(time[i]-i>=0)
        //result++
        //
        //   return
        // return result

        var result = 1
        val time = Array<Double>(dist.size){0.0}
        for(i in dist.indices)
        {
            val currentTime : Double =dist[i].toDouble()/speed[i].toDouble()
            time[i] = Math.ceil(currentTime)
        }

        Arrays.sort(time)

        for(i in 1 until time.size)
        {
            val arrival = time[i]-i
            if(arrival>0)
            {
                result++
            } else
            {
                return result
            }
        }
        return result
    }

    internal class Solution {
        fun numBusesToDestination(routes: Array<IntArray>, source: Int, target: Int): Int {
            if (source == target) {
                return 0
            }
            val adjList = HashMap<Int, ArrayList<Int>>()
            // Create a map from the bus stop to all the routes that include this stop.
            for (r in routes.indices) {
                for (stop in routes[r]) {
                    // Add all the routes that have this stop.
                    val route = adjList.getOrDefault(stop, ArrayList())
                    route.add(r)
                    adjList[stop] = route
                }
            }
            val q: Queue<Int> = LinkedList()
            val vis: MutableSet<Int> = HashSet(routes.size)
            // Insert all the routes in the queue that have the source stop.
            for (route in adjList[source]!!) {
                q.add(route)
                vis.add(route)
            }
            var busCount = 1
            while (!q.isEmpty()) {
                val size = q.size
                for (i in 0 until size) {
                    val route = q.remove()

                    // Iterate over the stops in the current route.
                    for (stop in routes[route]) {
                        // Return the current count if the target is found.
                        if (stop == target) {
                            return busCount
                        }

                        // Iterate over the next possible routes from the current stop.
                        for (nextRoute in adjList[stop]!!) {
                            if (!vis.contains(nextRoute)) {
                                vis.add(nextRoute)
                                q.add(nextRoute)
                            }
                        }
                    }
                }
                busCount++
            }
            return -1
        }
    };


    internal class Graph(n: Int, edges: Array<IntArray>) {
        private val adjMatrix: Array<IntArray>

        init {
            adjMatrix = Array(n) { IntArray(n) }
            Arrays.stream(adjMatrix).forEach { row: IntArray? ->
                Arrays.fill(
                    row,
                    1e9.toInt()
                )
            }
            for (e in edges) {
                adjMatrix[e[0]][e[1]] = e[2]
            }
            for (i in 0 until n) {
                adjMatrix[i][i] = 0
            }
            for (i in 0 until n) {
                for (j in 0 until n) {
                    for (k in 0 until n) {
                        adjMatrix[j][k] = Math.min(
                            adjMatrix[j][k],
                            adjMatrix[j][i] +
                                    adjMatrix[i][k]
                        )
                    }
                }
            }
        }

        fun addEdge(edge: IntArray) {
            val n = adjMatrix.size
            for (i in 0 until n) {
                for (j in 0 until n) {
                    adjMatrix[i][j] = Math.min(
                        adjMatrix[i][j],
                        adjMatrix[i][edge[0]] +
                                adjMatrix[edge[1]][j] +
                                edge[2]
                    )
                }
            }
        }

        fun shortestPath(node1: Int, node2: Int): Int {
            return if (adjMatrix[node1][node2] == 1e9.toInt()) -1 else adjMatrix[node1][node2]
        }
    }

    fun sortVowels(s: String): String {

        var result = ""
        var vowels = ""
        var i=0

        s.forEach{ ch->
            if(ch.isVowel())
                vowels+=ch
        }

       val sorted = vowels.toCharArray().apply { sort() }

        s.forEach{ ch->
            if(ch.isVowel())
            { result+=sorted[i]
                i++}
            else
            {
                result+=ch
            }
        }

        return result
    }

    fun Char.isVowel() : Boolean
    {
        return this=='A' || this=='E' || this=='I' || this=='O' || this=='U' || this=='a' || this=='e' || this=='i' || this=='o' || this=='u'
    }


    fun countPalindromicSubsequence(s: String): Int {
        val letters= mutableSetOf<Char>()
        for (c in s.toCharArray()) {
            letters.add(c)
        }
        var ans = 0
        for (letter in letters) {
            var i = -1
            var j = 0
            for (k in 0 until s.length) {
                if (s[k] == letter) {
                    if (i == -1) {
                        i = k
                    }
                    j = k
                }
            }
            val between = mutableSetOf<Char>()
            for (k in i + 1 until j) {
                between.add(s[k])
            }
            ans += between.size
        }
        return ans
    }

}
internal class Solution {
    fun findDifferentBinaryString(nums: Array<String>): String {
        val ans = StringBuilder()
        for (i in nums.indices) {
            val curr = nums[i][i]
            ans.append(if (curr == '0') '1' else '0')
        }
        return ans.toString()
    }

    internal class Solution {
        fun minPairSum(nums: IntArray): Int {
            Arrays.sort(nums)
            var maxSum = 0
            for (i in 0 until nums.size / 2) {
                maxSum = Math.max(maxSum, nums[i] + nums[nums.size - 1 - i])
            }
            return maxSum
        }
    }
}


//internal class Solution {
//    fun maxFrequency(nums: IntArray, k: Int): Int {
//        Arrays.sort(nums)
//        var left = 0
//        var curr: Long = 0
//        for (right in nums.indices) {
//            val target = nums[right]
//            curr += target.toLong()
//            if ((right - left + 1) * target - curr > k) {
//                curr -= nums[left].toLong()
//                left++
//            }
//        }
//        return nums.size - left
//    }
//}