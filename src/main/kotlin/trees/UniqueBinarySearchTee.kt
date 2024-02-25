package trees

import trees.nodes.TreeNode


class UniqueBinarySearchTee {

    fun generateTrees(n: Int): List<TreeNode?> {
        return helper(1, n)
    }

    fun helper(start: Int, end: Int): List<TreeNode?> {
        val res = mutableListOf<TreeNode?>()

        if (start > end) {
            res.add(null)
            return res
        }
        if (start == end) {
            val root = TreeNode(start)
            return listOf(root)
        }

        val result = mutableListOf<TreeNode>()
        for (i in start..end) {
            val leftBst = helper(start, i - 1)
            val rightBst = helper(i + 1, end)

            for (lb in leftBst) {
                for (rb in rightBst) {
                    val root = TreeNode(i)
                    root.left = lb
                    root.right = rb
                    result.add(root)
                }
            }
        }
        return result
    }

}


// Base
// current i>n
// return null
// if i==n
//we have reached to the end and we need need to return arrayof root
// every i we need to consider as a root
// then we need to find left-bsts and right bst
// now we need to assign left and right to current root
// once that assigned we need to add root to the answer list
