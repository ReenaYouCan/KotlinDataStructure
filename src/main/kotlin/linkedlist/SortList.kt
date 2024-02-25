package linkedlist

class SortList {

    internal class Solution {
        fun sortList(head: ListNode?): ListNode? {
            if (head == null || head.next == null) return head
            val mid = getMid(head)
            val left = sortList(head)
            val right = sortList(mid)
            return merge(left, right)
        }

        fun merge(list1: ListNode?, list2: ListNode?): ListNode? {
            var list1 = list1
            var list2 = list2
            val dummyHead = ListNode(-1)
            var tail: ListNode? = dummyHead
            while (list1 != null && list2 != null) {
                if (list1.`val` < list2.`val`) {
                    tail!!.next = list1
                    list1 = list1.next
                    tail = tail.next
                } else {
                    tail!!.next = list2
                    list2 = list2.next
                    tail = tail.next
                }
            }
            tail!!.next = list1 ?: list2
            return dummyHead.next
        }

        fun getMid(head: ListNode?): ListNode? {
            var head = head
            var midPrev: ListNode? = null
            while (head != null && head.next != null) {
                midPrev = if (midPrev == null) head else midPrev.next
                head = head.next!!.next
            }
            val mid = midPrev!!.next
            midPrev.next = null
            return mid
        }
    }

}