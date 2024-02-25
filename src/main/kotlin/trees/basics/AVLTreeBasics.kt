package trees.basics

import trees.nodes.TreeNode

fun main(args: Array<String>) {
    val avlTreeBasics = AVLTreeBasics()


    val nums = intArrayOf(25, 2, 3, 4, 5, 90, 19, 4, 6, 2, 9, 4)

    avlTreeBasics.populate(nums)
    avlTreeBasics.display()
}

class AVLTreeBasics {

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

        return rotate(node)
    }

    private fun rotate(node: TreeNode): TreeNode {
        if (height(node.left) - height(node.right) > 1) {
            // Left heavy
            if (height(node.left!!.left) - height(node.left!!.right) > 0) {
                //left left case
                return rightRotate(node)
            }
            if (height(node.left!!.left) - height(node.left!!.right) < 0) {
                //LEft Rotate Cases
                node.left = leftRotate(node.left!!)
                return rightRotate(node)

            }
        }

        if (height(node.left) - height(node.right) < -1) {
            // Left heavy
            if (height(node.right!!.left) - height(node.right!!.right) < 0) {
                //right right case
                return leftRotate(node)
            }
            if (height(node.right!!.left) - height(node.right!!.right) > 0) {
                //left right Cases
                node.right = rightRotate(node.left!!)
                return leftRotate(node)

            }
        }
        return node
    }

    private fun leftRotate(c: TreeNode): TreeNode {
        val p = c.right
        val t = p!!.left

        p.left = c
        c.right = t

        p.height = Math.max(height(p.left),height(p.right))
        c.height = Math.max(height(c.left),height(c.right))

        return p
    }

    private fun rightRotate(p: TreeNode): TreeNode {
        val c = p.left
        val t = p.right
        c!!.right = p
        p.left = t

        p.height = Math.max(height(p.left),height(p.right))
        c.height = Math.max(height(c.left),height(c.right))

        return c
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