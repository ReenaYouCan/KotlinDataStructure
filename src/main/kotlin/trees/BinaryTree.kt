package trees

import trees.nodes.TreeNode

class BinaryTree() {

    var root: TreeNode? = null

    //insert element
    fun insert(value: Int) {
        root = TreeNode(value)
    }

}