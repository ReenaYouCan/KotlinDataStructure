package trees

import trees.nodes.TreeNode

/**
 * 111. Minimum Depth of Binary Tree
 * Easy
 * 6.6K
 * 1.2K
 * Companies
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * Example 2:
 *
 * Input: root = [2,null,3,null,4,null,5,null,6]
 * Output: 5
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 105].
 * -1000 <= Node.val <= 1000
 *
 */

/**
 *  §§§§§
 */
class MinimumDepth {
    fun minDepth(root: TreeNode?): Int {
        return helper(root)
    }

    fun helper(root: TreeNode?): Int {
        if (root == null)
            return 0

        if (root.left == null) {
            return 1 + helper(root.right)
        }

        if (root.right == null) {
            return 1 + helper(root.left)
        }

        val left = helper(root.left)
        val right = helper(root.right)

        return 1 + Math.min(left, right)
    }
}