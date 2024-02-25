package linkedlist

class GetMid {
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