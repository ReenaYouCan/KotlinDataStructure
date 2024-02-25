package graph.dijkstra

import java.util.*

fun main(args: Array<String>) {

    val times = arrayOf(
        intArrayOf(2,1,1),
        intArrayOf(2,3,1),
        intArrayOf(3,4,1)
    )

//    [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
    val result = NetworkDelay().networkDelayTime(times,4,2)
    println(result)
}
class NetworkDelay {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        // build graph from times
        // Pair -> u-> key
        //          v-> pair.first
        //          w-> pair.second // time needs
        val graph = hashMapOf<Int,MutableList<Pair<Int,Int>>>()
        for(time in times)
        {
            val u = time[0] // key
            val v = time[1] // target node
            val w = time[2]

            graph.computeIfAbsent(u){mutableListOf()}.add(Pair(v,w)) //
        }

        // As it says minimum time needed
        val pq = PriorityQueue<Pair<Int,Int>>{o1,o2->o1.second - o2.second}
        // array to maintain distance for each node
        val distance = IntArray(n){Integer.MAX_VALUE}
        distance[k] = 0

        pq.add(Pair(k,0))

        while(pq.isNotEmpty())
        {
            val u = pq.poll()
            val neighbours = graph[u.first]
            val uTime = u.second

            for(neighbour in neighbours!!)
            {
                val vertex = neighbour.first
                val time = neighbour.second

                val totalTime = time + uTime
                if(distance[vertex]>totalTime)
                {
                    distance[vertex] = totalTime
                    pq.add(Pair(vertex,totalTime))
                }
            }
        }

        for(d in distance)
        {
            if(d==Integer.MAX_VALUE)
                return -1
        }

        return distance.max()
    }
}