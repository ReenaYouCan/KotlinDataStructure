package linkedlist

class PartitionList {

    var smallTail : ListNode? = null
    var smallHead : ListNode? = null
    var largeTail : ListNode? = null
    var largeHead : ListNode? = null

    fun partition(head: ListNode?, x: Int): ListNode? {

        var curr = head

        while(curr!=null)
        {
            if(x>curr.`val`)
            {
                appendSmall(curr)
            } else
            {
                appendLarge(curr)
            }

            curr = curr.next
        }

        smallTail!!.next = largeHead
        return smallHead

    }

    fun appendSmall(node:ListNode)
    {
        if(smallHead==null)
        {
            smallHead = node
        }


        if(smallTail==null)
        {
            smallTail = node
            smallHead!!.next = smallTail
        } else
        {
            smallTail!!.next = node
            smallTail = node
        }
    }

    fun appendLarge(node:ListNode)
    {
        if(largeHead==null)
        {
            largeHead = node
        }

        if(largeTail==null)
        {
            largeTail = node
            largeHead!!.next = largeTail
        }  else
        {
            largeTail!!.next = node
            largeTail = node
        }

    }
}