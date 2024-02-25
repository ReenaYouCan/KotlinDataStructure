package linkedlist

class MergeTwoSortedList {
    var head: ListNode? = null
    var curr: ListNode? = null

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

        var p1 = list1
        var p2 = list2

        while (p1 != null && p2 != null) {
            if (p1.`val` < p2.`val`) {
                updateList(p1)
                p1 = p1.next
            } else {
                updateList(p2)
                p2 = p2.next

            }
        }

        while (p1 != null) {
            updateList(p1)
            p1 = p1.next
        }

        while (p2 != null) {
            updateList(p2)
            p2 = p2.next
        }
        return head
    }

    fun updateList(node: ListNode) {
        if (head == null) {
            head = node
            curr = head
        } else {
            curr!!.next = node
            curr = curr!!.next
        }
    }

    fun middleNode(head: ListNode?): ListNode? {
        var p1 = head
        var p2 = head

        while (p2?.next != null) {
            p1 = p1!!.next
            p2 = p2.next!!.next
        }

        return p1
    }
}