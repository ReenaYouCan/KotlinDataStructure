package graph


fun main(args: Array<String>) {
    val reorderRoutesToMakeAllPathLeadToTheCIty = ReorderRoutesToMakeAllPathLeadToTheCIty()
//    [0,1],[1,3],[2,3],[4,0],[4,5]
    val input = arrayOf(intArrayOf(0, 1), intArrayOf(1, 3), intArrayOf(2, 3), intArrayOf(4, 0), intArrayOf(4, 5))
    println(reorderRoutesToMakeAllPathLeadToTheCIty.minReorder(4, input))
}

// Given
class ReorderRoutesToMakeAllPathLeadToTheCIty {
    // Create Graph from given check the pairs
    // Put all pairs in Set to check further
    // dfs
    //node and its adjacent elements
    // if(!el,node) exisst then increament count

    //visited
    //dfs for its elements


    // create a graph from given connections
    // Which will have two edges
    // Inward and outward
    // Mark the edge is real or fake
    //
    // Do a DFS Traversal to graph and check if real or not towards the zero

    var count = 0
    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        // How to create Adjacency List

        val graph = hashMapOf<Int, MutableList<Pair>?>()
        for (connection in connections) {
            val u = connection[0]
            val v = connection[1]

            val realPair = Pair(v, true)

            var vList: MutableList<Pair>?
            if (graph.containsKey(u)) {
                vList = graph[u]
                vList?.add(realPair)
            } else {
                vList = mutableListOf(realPair)
            }
            graph[u] = vList

            val fakePair = Pair(u, false)

            var vFakeList: MutableList<Pair>?
            if (graph.containsKey(v)) {
                vFakeList = graph[v]
                vFakeList?.add(fakePair)
            } else {
                vFakeList = mutableListOf(fakePair)
            }
            graph[v] = vFakeList
        }

        dfs(0, -1, graph)
        return count
    }

    fun dfs(u: Int, parent: Int, graph: HashMap<Int, MutableList<Pair>?>) {
        val neighbours = graph[u]

        for (neighbour in neighbours!!) {
            val v = neighbour.v
            if (v != parent) {
                if (neighbour.isReal) {
                    count++
                }
                dfs(v, u, graph)
            }
        }

    }

    data class Pair(var v: Int, var isReal: Boolean)

}