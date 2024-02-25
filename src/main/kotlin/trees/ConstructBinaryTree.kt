package trees

import trees.nodes.TreeNode

class ConstructBinaryTree {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty())
            return null

        val root = preorder[0]
        var index = 0

        for (i in inorder.indices) {
            if (inorder[i] == root) {
                index = i
            }
        }

        val node = TreeNode(root)
        node.left = buildTree(preorder.copyOfRange(1, index + 1), inorder.copyOfRange(0, index))
        node.right = buildTree(preorder.copyOfRange(index+1, preorder.size), inorder.copyOfRange(index + 1, inorder.size))

        return node
    }
}