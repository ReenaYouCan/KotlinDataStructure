package trees.basics

import trees.nodes.TreeNode

class BinaryTreeTraversal {

    fun inorder(node: TreeNode?) {
        if (node == null)
            return

        inorder(node.left)
        println(node.`val`)
        inorder(node.right)
    }

    fun postOrder(node: TreeNode?) {
        if (node == null)
            return

        postOrder(node.left)
        postOrder(node.right)
        println(node.`val`)
    }

    fun preOrder(node: TreeNode?) {
        if (node == null) return

        println(node.`val`)
        preOrder(node.left)
        preOrder(node.right)
    }
}