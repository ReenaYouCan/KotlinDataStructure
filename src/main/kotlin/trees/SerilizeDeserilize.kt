package trees

import trees.nodes.TreeNode

fun main(args: Array<String>) {

}

class SerilizeDeserilize {

    val serialize = mutableListOf<String>()

    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): MutableList<String> {
        return serialize
    }


    fun helper(node: TreeNode?, strings: MutableList<String>) {
        if (node == null) {
            strings.add("null")
            return
        }

        strings.add("${node.`val`}")
        helper(node.left, strings)
        helper(node.right, strings)

    }


    // Decodes your encoded data to tree.
    fun deserialize(data: MutableList<String>): TreeNode? {
        data.sorted()
        return deserializeHelper(data)
    }

    private fun deserializeHelper(data: MutableList<String>): TreeNode? {
        val curr = data.removeAt(data.size - 1)

        if (curr[0] == 'n') {
            return null
        }

        val node = TreeNode(curr.toInt())
        node.left = deserializeHelper(data)
        node.right = deserializeHelper(data)

        return node
    }

}