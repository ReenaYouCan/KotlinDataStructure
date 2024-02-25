package trees

import trees.nodes.SegmentTreeNode
import java.lang.StringBuilder

fun main(args: Array<String>) {
    val input = intArrayOf(3, 8, 6, 7, -2, -8, 4, 9)
    val segmentTree = SegmentTree(input)
//    segmentTree.display()
//    println(segmentTree.query(2,5))
    println(segmentTree.update(4,44))


}

class SegmentTree(arr: IntArray) {
    // Create a tree using
    var root: SegmentTreeNode

    init {
        root = constructTree(arr, 0, arr.size-1)
    }

    // Time complexity to create a tree is o(N)
    private fun constructTree(arr: IntArray, startIndex: Int, endIndex: Int): SegmentTreeNode {

        if (startIndex == endIndex) {
            // Leaf Node
            val leafNode = SegmentTreeNode(startInterval = startIndex, endInterval = endIndex)
            leafNode.data = arr[startIndex]
            return leafNode
        }

        // Create new node with index you are at
        val node = SegmentTreeNode(startInterval = startIndex, endInterval = endIndex)
        val mid = startIndex + (endIndex - startIndex) / 2

        node.left = constructTree(arr, startIndex, mid)
        node.right = constructTree(arr, mid + 1, endIndex)
        node.data = node.left?.data?.plus(node.right?.data ?: 0) ?: 0

        return node
    }

    fun display() {
        display(root)
    }

    fun display(node: SegmentTreeNode) {

        var str = StringBuilder()

        // Print left child
        node.left?.let {
            str.append("Interval=[${it.startInterval}")
            str.append("_")
            str.append("${it.endInterval}]")
            str.append("and")
            str.append("${it.data}")
            str.append(" => ")
        } ?: run {
            str.append("No Left child")
        }

        // Print Current Node
        node.let {
            str.append("Interval=[${it.startInterval}")
            str.append("_")
            str.append("${it.endInterval}]")
            str.append(" and data is ")
            str.append("${it.data}")
            str.append(" <= ")
        }

        // Print right child
        node.right?.let {
            str.append("Interval=[${it.startInterval}")
            str.append("_")
            str.append("${it.endInterval}]")
            str.append(" and data is ")
            str.append("${it.data}")
            str.append(" \n ")
        } ?: run {
            str.append("No Right child")
        }

        println(str.toString())

        if (node.left != null) {
            display(node.left!!)
        }

        if (node.right != null) {
            display(node.right!!)
        }
    }

    // Query Segment Tree
    fun query(qsi: Int, qei: Int): Int {
        return query(root, qsi, qei)
    }

    fun query(node: SegmentTreeNode, qsi: Int, qei: Int): Int {

        //node interval is completely lying inside the query
        if (node.startInterval >= qsi && node.endInterval <= qei) {
            return node.data
        } else if (node.startInterval > qei || node.endInterval < qsi) { //completely outside
            return 0
        } else {
            //Overlapping
            val left = node.left?.let { query(it, qsi, qei) } ?: 0

            val right = node.right?.let { query(it, qsi, qei) } ?: 0


            return left + right
        }
    }

    fun update(index: Int, value: Int): Int {
        return update(root, index, value)
    }

    private fun update(node: SegmentTreeNode, index: Int, value: Int): Int {
        // Check boundries if given index falls in
        if (index >= node.startInterval && index <= node.endInterval) {
            // We found a value
            if (node.startInterval == index && node.endInterval == index) {
                node.data = value
                return node.data
            } else {
                // The element must be in left side or right side
                val left = node.left?.let { update(it, index, value) } ?: 0
                val right = node.right?.let { update(it, index, value) } ?: 0

                node.data = left + right

                return node.data
            }

        }
        return node.data
    }


}