package linkedlist

import graph.Node

class DeepCopy {
    fun copyRandomList(node: ListNode?): ListNode? {

        if (node == null)
            return null

        val map = HashMap<ListNode, ListNode>()

        var curr = node
        var prev: ListNode? = null
        var newNode: ListNode? = null

        // Fill Next pointer
        while (curr != null) {
            val temp = ListNode(curr.`val`)
            map[curr] = temp

            if (newNode == null) {
                newNode = temp
                prev = newNode
            } else {
                prev?.next = temp
                prev = temp
            }
            curr = curr.next
        }

        curr = node
        var newCurr = newNode
        while (curr!=null)
        {
            if (curr.random==null)
            {
                newNode?.random = null
            } else{
                val random = curr.random
                val newRandom = map[random]
                newCurr?.random = newRandom

            }
            curr = curr.next
            newCurr = newCurr?.next
        }

        return newNode

    }
}