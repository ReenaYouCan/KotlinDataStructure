package linkedlist

import java.util.Stack

//https://leetcode.com/problems/remove-nodes-from-linked-list/description/?envType=daily-question&envId=2024-05-06
class RemoveNodesFromLinkedList {
    fun removeNodes(head: ListNode?): ListNode? {

        val stack = Stack<ListNode>()
        var current = head

        //Add nodes to the stack
        while (current != null) {
            stack.push(current)
            current = current.next
        }

        current = stack.pop()
        var max = current.`val`
        var result = ListNode(max)

        // Remove nodes from the stack and add to result
        while (stack.isNotEmpty()) {
            current = stack.pop()
            // Current should not be added to the result
            if (current.`val` < max) {
                continue
            } else {             // Add new node with current's value to front of the result
                val node = ListNode(current.`val`)
                node.next = result
                result = node
                max = current.`val`

            }

        }
        return result
    }
}