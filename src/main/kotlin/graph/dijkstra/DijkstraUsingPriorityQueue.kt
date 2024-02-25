package graph.dijkstra

import java.util.*
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    val dijkstraUsingPriorityQueue = DijkstraUsingPriorityQueue()
}

class DijkstraUsingPriorityQueue {

    // Build priority queue with min heap
    // Build Graph from

    fun dijkstra(source: Int, adj: HashMap<Int, List<Int>>): Array<Int> {
        val result = IntArray(adj.size) { Int.MAX_VALUE }

        // Define PriorityQueue
        // First is distance and second is vertex
        val pq = PriorityQueue<Pair<Int, Int>> { o1, o2 -> o1.first - o2.first } // Be dafault its min heap
        pq.add(Pair(0, source))

        result[source] = 0

        while (pq.isNotEmpty()) {
            val vertex = pq.poll()

            val neighbours = adj[vertex.second]

            neighbours?.forEach {

            }
        }
        return arrayOf()
    }

}