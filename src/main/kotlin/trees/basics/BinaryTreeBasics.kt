package trees.basics

import trees.nodes.TreeNode

fun main(args: Array<String>) {
    val binaryTreeBasics = BinaryTreeBasics()
    binaryTreeBasics.populate()
    binaryTreeBasics.display()
}

class BinaryTreeBasics {
    lateinit var root: TreeNode

    //insert elements
    fun populate() {
        println("Enter the root node value:")
        val value = readln().toInt()
        root = TreeNode(value)
        helper(root)
    }

    private fun helper(node: TreeNode) {
        println("Do you want enter left of " + node.`val`)
        val isLeft = readln().toBoolean()
        if (isLeft) {
            println("Enter the value of the left of : " + node.`val`)
            val value = readln().toInt()
            node.left = TreeNode(value)
            helper(node.left!!)
        }
        println("Do you want enter right of " + node.`val`)
        val isRight = readln().toBoolean()
        if (isRight) {
            println("Enter the value of the right of : " + node.`val`)
            val value = readln().toInt()
            node.right = TreeNode(value)
            helper(node.right!!)
        }
    }

    fun display() {
        display(root, "")
    }

    fun display(root: TreeNode?, indent: String) {
        if (root == null)
            return
        println(indent + root.`val`)
        display(root.left, indent + "\t")
        display(root.right, indent + "\t")

    }

}