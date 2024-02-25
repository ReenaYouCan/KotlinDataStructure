package trees

import trees.nodes.TreeNode

class MaximumDepth {
    fun maxDepth(root: TreeNode?): Int {
        return helper(root)
    }

    fun helper(root: TreeNode?): Int {
        if (root == null)
            return 0

        val left = helper(root.left)
        val right = helper(root.right)

        return 1 + Math.max(left, right)
    }
}