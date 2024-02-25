package graph


class Graph(vertex: Int) {

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
}