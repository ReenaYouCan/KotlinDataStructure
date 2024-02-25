package trees

import trees.nodes.TreeNode


/**
 * Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
 *
 * You can return the answer in any order.
 *
 * Example 1:
 *
 *
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
 * Output: [7,4,1]
 * Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
 * Example 2:
 *
 * Input: root = [1], target = 1, k = 3
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 500].
 * 0 <= Node.val <= 500
 * All the values Node.val are unique.
 * target is the value of one of the nodes in the tree.
 * 0 <= k <= 1000
 *
 * graph.Solution
 * In the given tree, each node only has pointers to its left and right child nodes,
 * making the typical tree traversal approach only applicable to the subtree rooted at the target node.
 * We cannot access other parts of the tree beyond the subtree as we can't access the parent,
 * which implies the need to establish additional connections beyond the child node pointers.
 *
 * Implementing Parent Pointer
 *
 *
 *
 * 2. Approach 2: Depth-First Search on Equivalent Graph
 * The previous approach of dynamically adding attributes is not a recommended practice. A safer method is to transform the given binary tree into an equivalent graph, where each pointer is treated as an undirected edge. Hence, the graph retains all the connected nodes from the original binary tree, including the pointers from children to parents. Consequently, we can perform a regular search in this graph, starting with depth-first search algorithm as an example.
 *
 * img
 *
 * In the equivalent graph, we only need to recursively visit all unvisited neighboring nodes of the current node, which include nodes that are equivalent to the left and right children and the parent in the original tree.
 *
 * Similarly, we can use a hash set to keep track of all the visited nodes. Whenever we find an unvisited neighbor node, we add it to the hash set so it won't be visited anymore.
 *
 *
 * Algorithm
 * We will build a hash map graph. Define a recursive function build_graph(cur, parent) to recursively build the equivalent graph: If both cur and parent are not empty, add an edge that connects cur and parent in the hash map graph. Then recursively call add_parent on the left and right children of cur:
 *
 * If cur.left is not empty, call add_parent(cur.left, cur)
 * If cur.right is not empty, call add_parent(cur.right, cur)
 * Call add_parent(root, None) to build the equivalent graph, note that the root node does not have a parent node.
 *
 * Initialize an empty array answer and an empty hash set visited.
 *
 * Define another recursive function dfs(cur, distance) to recursively find all nodes with a distance of k to node target:
 *
 * Add cur to visited so it won't be revisited later.
 * If distance = k, it means cur is one of the destination nodes, add it to answer, and return.
 * Recursively call dfs on the unvisited neighbors of cur.
 * Add target.val to visited. Call dfs(target.val, 0) to find all destination nodes with a distance of k to the target node.
 *
 * Return answer when the DFS is complete.
 */

fun main(args: Array<String>) {
    val allNodesDistanceKinBinaryTree = AllNodesDistanceKinBinaryTree()
    val root = TreeNode(3)
    root.left = TreeNode(5)
    root.right = TreeNode(1)

    val target = TreeNode(5)

    println(allNodesDistanceKinBinaryTree.distanceK(root, target, 1))
}

class AllNodesDistanceKinBinaryTree {

    fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
        // Build Graph
        val graph = mutableMapOf<Int, MutableList<Int>>()
        buildGraph(root, null, graph)

        val answer = mutableListOf<Int>()
        val visited = mutableSetOf<Int>()

        visited.add(target!!.`val`)

        dfs(target.`val`, 0, k, answer, graph, visited)
        return answer
    }

    //Build graph from given tree
    fun buildGraph(
        current: TreeNode?,
        parent: TreeNode?,
        graph: MutableMap<Int, MutableList<Int>>
    ) {
        if (current != null && parent != null) {
            graph.computeIfAbsent(current.`val`) { k -> ArrayList() }.add(parent.`val`)
            graph.computeIfAbsent(parent.`val`) { k -> ArrayList() }.add(current.`val`)
        }
        if (current?.left != null) {
            buildGraph(current.left, current, graph)
        }
        if (current?.right != null) {
            buildGraph(current.right, current, graph)
        }

    }


    fun dfs(
        current: Int, distance: Int, k: Int, answer: MutableList<Int>,
        graph: MutableMap<Int, MutableList<Int>>,
        visited: MutableSet<Int>
    ) {
        if (distance == k) {
            answer.add(current)
        }

        val neighbors = graph.getOrDefault(current, ArrayList())
        for (neighbor in neighbors) {
            if (!visited.contains(neighbor)) {
                visited.add(neighbor)
                dfs(neighbor, distance + 1, k, answer, graph, visited)
            }
        }
    }
}