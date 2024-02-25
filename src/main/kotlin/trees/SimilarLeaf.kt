package trees

import trees.nodes.TreeNode

class SimilarLeaf {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()

        helper(root1, list1)
        helper(root2, list2)

        return list1 == list2
    }

    fun helper(node: TreeNode?, list: MutableList<Int>) {
        if (node!!.left == null && node.right == null)
            list.add(node.`val`)

        helper(node.left, list)
        helper(node.right, list)
    }
}