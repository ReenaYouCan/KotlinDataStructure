package trees.basics

import trees.nodes.TreeNode

fun main(args: Array<String>) {
    val binarySearchTreeBasics = BinarySearchTreeBasics()


    val nums = intArrayOf(25, 2, 3, 4, 5, 90, 19, 4, 6, 2, 9, 4)

    binarySearchTreeBasics.populate(nums)
    binarySearchTreeBasics.display()
}

class BinarySearchTreeBasics {

    var root: TreeNode? = null

    fun height(node: TreeNode?): Int {
        if (node == null)
            return -1

        return node.height
    }

    fun isEmpty(): Boolean {
        return root == null
    }

    private fun displayHelper(node: TreeNode?, details: String) {
        if (node == null) {
            return
        }

        println("$details: ${node.`val`}")
        displayHelper(node.left, "Left child of ${node.`val`} : ")
        displayHelper(node.right, "Right child of ${node.`val`} :")
    }

    fun display() {
        displayHelper(root, "Root Node: ")
    }

    fun populateSorted(input: IntArray, left: Int, right: Int) {
        if (left >= right) {
            return
        }

        val mid = left + (right - left) / 2
        insertHelper(input[mid])
        populateSorted(input, left, mid - 1)
        populateSorted(input, right, mid + 1)
    }

    fun populate(input: IntArray) {

        populateSorted(input, 0, input.size - 1)

        // Normal binary tree
//        for (num in input) {
//            insertHelper(num)
//        }
    }

    fun insertHelper(value: Int) {
        root = insert(value, root)
    }

    fun insert(value: Int, node: TreeNode?): TreeNode {

        if (node == null) {
            return TreeNode(value)
        }

        if (value > node.`val`) {
            node.right = insert(value, node.right)
        }

        if (value < node.`val`) {
            node.left = insert(value, node.left)
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1

        return node
    }

    private fun balanced(node: TreeNode?): Boolean {
        if (node == null) {
            return true
        }

        return Math.abs(height(root!!.left) - height(root!!.right)) <= 1 && balanced(node.left) && balanced(node.right)
    }

    fun isBalanced(): Boolean {
        return balanced(root)
    }


}