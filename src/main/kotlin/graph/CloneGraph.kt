package graph

import java.util.*


//https://leetcode.com/problems/clone-graph/submissions/421662481/


class Node(var `val`: Int) {
    var neighbors = arrayListOf<Node>()
}

/**
 * How the graph can be cloned
 * WE need access to the node based on insertion order so if we push nodes to the
 * queue then we can easily keep the track of inserted node and that can be easily assigned the cloned graph
 * Take visited hashmap with key as original node and values as cloned node
 * Take queue to iterate over the tree and get that tree
 *
 * put node to the key
 *
 *
 */
class CloneGraph {
    fun cloneGraph(node: Node?): Node? {

        if (node == null) return node

        val visited = hashMapOf<Node, Node>()
        val queue: Queue<Node> = LinkedList()

        queue.add(node)
        visited[node] = Node(node.`val`) // It has empty neighbors

        while (queue.isNotEmpty()) {
            val tempNode = queue.poll()
            for (neighbor in tempNode.neighbors)
            {
                if(!visited.containsKey(neighbor))
                {
                    visited[neighbor] = Node(neighbor.`val`)
                    queue.add(neighbor)
                }
                visited[tempNode]!!.neighbors.add(visited[neighbor]!!)
            }

        }

        return visited[node]
    }


}