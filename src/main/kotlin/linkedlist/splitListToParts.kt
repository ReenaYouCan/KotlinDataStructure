package linkedlist

class SplitListToParts {
    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        val result = arrayOfNulls<ListNode>(k)

        val size = getSizeOfLinkedList(head, 0)

        val div = size / k

        var rem = size % k

        var curr = head
        var prev: ListNode? = null

        for (i in 0 until k) {
            result[i] = curr
            for (j in 0 until (div + (if (rem>0) 1 else 0))) {
                prev = curr
                curr = curr?.next
            }
            prev?.next = null
            rem--
        }

        return result
    }

    private fun getSizeOfLinkedList(head: ListNode?, size: Int): Int {

        if (head == null) {
            return size
        }

        return getSizeOfLinkedList(head.next, size + 1)
    }


}
