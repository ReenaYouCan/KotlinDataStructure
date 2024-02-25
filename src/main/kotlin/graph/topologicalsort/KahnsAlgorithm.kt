package graph.topologicalsort

import graph.Graph
import java.util.LinkedList
import java.util.Queue


//https://www.geeksforgeeks.org/topological-sorting-indegree-based-solution/
/*
Print topological sorting of a graph using indegrees
* */
class KahnsAlgorithm(vertex: Int) {


    // An Array of List which contains
    // references to the Adjacency List of
    // each vertex
    var adj = Array(vertex) { mutableListOf<Int>() }


    // Constructor
    init {
        for (i in 0 until vertex) adj[i] = ArrayList()
    }

    // Function to add an edge to graph
    fun addEdge(u: Int, v: Int) {
        adj[u].add(v)
    }

    fun topologicalSort(vertex: Int) {
        /* Create a array to store indegrees of all vertices. Initialize allindegrees as 0.*/
        val indree = Array(vertex) { 0 }

        /*Traverse adjacency lists to fill indegree of vertices.
        This step takes O(V+E) time*/

        for (i in 0 until vertex) {
            val edges = adj[i]
            for (e in edges) {
                indree[e]++
            }
        }

        val queue: Queue<Int> = LinkedList()
        for (v in 0 until vertex) {
            if (indree[v] == 0)
                queue.add(v)
        }

        // Initialize count of visited vertices
        var count = 0
        val result = mutableListOf<Int>()
        while (queue.isNotEmpty()) {
            // Extract front of queue
            // (or perform dequeue)
            // and add it to topological order

            val u = queue.poll()
            result.add(u)
            /*
            * Iterate through all its neighbouring nodes
            * of dequeued node u and decrease their in-degree
            * by 1
            * */

            for (nodeU in adj[u]) {
                // If in-degree becomes zero,
                // add it to queue
                if (--indree[nodeU] == 0) {
                    queue.add(nodeU)
                }
            }
            count++
        }

        if (count != vertex) {
            println("There is cycle in graph")
            return
        }

        for (v in result) {
            print("$v ")
        }
    }
}

fun main(args: Array<String>) {
    val graph = Graph(6)
    graph.addEdge(5,2)
    graph.addEdge(5,0)
    graph.addEdge(4,0)
    graph.addEdge(4,1)
    graph.addEdge(2,3)
    graph.addEdge(3,1)


}






