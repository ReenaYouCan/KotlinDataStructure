package linkedlist

class ReverseLinkedList {
    fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        var leftNode : ListNode? = null
        var rightNode : ListNode? = null
        var reverseNode : ListNode? = null

        var curr = head
        while(curr?.next != null)
        {
            if(curr.next!!.`val`==left)
            {
                //Previous node
                leftNode = curr
                reverseNode = curr.next

                while(curr != null && curr.`val`!=right)
                {
                    curr = curr.next
                }
                rightNode = curr?.next
                curr?.next = null
            } else
            {
                curr = curr.next
            }
        }

        val node = reverse(reverseNode)
        node?.next = rightNode
        leftNode?.next = node

        return head
    }

    fun reverse(node:ListNode?) : ListNode?
    {
        if(node==null)
            return null

        val reverse = reverse(node.next)
        node.next?.next = node
        node.next = null

        return reverse
    }


    internal class Solution {
        // Object level variables since we need the changes
        // to persist across recursive calls and Java is pass by value.
        private var stop = false
        private var left: ListNode? = null
        fun recurseAndReverse(right: ListNode?, m: Int, n: Int) {

            // base case. Don't proceed any further
            var right = right
            if (n == 1) {
                return
            }

            // Keep moving the right pointer one step forward until (n == 1)
            right = right!!.next

            // Keep moving left pointer to the right until we reach the proper node
            // from where the reversal is to start.
            if (m > 1) {
                left = left!!.next
            }

            // Recurse with m and n reduced.
            recurseAndReverse(right, m - 1, n - 1)

            // In case both the pointers cross each other or become equal, we
            // stop i.e. don't swap data any further. We are done reversing at this
            // point.
            if (left == right || right!!.next == left) {
                stop = true
            }

            // Until the boolean stop is false, swap data between the two pointers
            if (!stop) {
                val t = left!!.`val`
                left!!.`val` = right!!.`val`
                right.`val` = t

                // Move left one step to the right.
                // The right pointer moves one step back via backtracking.
                left = left!!.next
            }
        }

        fun reverseBetween(head: ListNode?, m: Int, n: Int): ListNode? {
            left = head
            stop = false
            recurseAndReverse(head, m, n)
            return head
        }
    }
}