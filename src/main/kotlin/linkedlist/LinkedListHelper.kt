package linkedlist

class LinkedListHelper {
    var head: ListNode? = null
    var tail: ListNode? = null
    var size: Int = 0

    fun addNodeToFront(node: ListNode) { //Update Head
        node.next = head
        head = node
        if (tail == null) {
            tail = head
        }
        size += 1           // Increment size by one

    }

    fun addNodeToFront(value: Int) { //Update Head
        val current = ListNode(value)
        current.next = head
        head = current

        if (tail == null) { // Don't forget this
            tail = head
        }

        size += 1           // Increment size by one
    }

    fun addNodeToTheTail(node: ListNode) {
        tail?.next = node
        tail = node
    }

    fun addNodeToTheTail(value: Int) {
        val current = ListNode(value)

        if (tail == null) {
            addNodeToFront(current)
            return
        }
        tail?.next = current
        tail = current
        size += 1           // Increment size by one
    }

    fun insertAtIndex(value: Int, index: Int) {
        if (index == 0) {
            addNodeToFront(value)
            return
        }
        if (index == size) {
            addNodeToTheTail(value)
            return
        }

        var current = head
        var currentIndex = 1
        while (currentIndex < index) {
            current = current?.next
            currentIndex++
        }

        val newNode = ListNode(value)
        val temp = current?.next

        current?.next = newNode
        newNode.next = temp
    }

    fun displayNode() {
        var current = head

        while (current != null) {
            print("${current.`val`}->")
            current = current.next
        }
        print("null")
    }

    fun display(node: ListNode?) {
        if (node == null) {
            print("null")
            println()
            return
        }

        print("${node.`val`}->")
        // Perform things before entering to recursive call
        display(node.next)

        //perform things after coming from recursive call
//        print("${node.`val` * node.`val`}->")

    }


    fun rInsert(node: ListNode?, index: Int, value: Int) {
        if (index == 0) {
            val temp = node!!.next
            val newNode = ListNode(value)
            node.next = newNode
            newNode.next = temp
            return
        }

        rInsert(node!!.next, index - 1, value)
    }

    fun rInsertWithReturnNode(node: ListNode?, index: Int, value: Int): ListNode? {
        if (index == 0) {
            return ListNode(value, node)
        }

        node!!.next = rInsertWithReturnNode(node.next, index - 1, value)

        return node
    }

    fun recursiveReverseList(node: ListNode?) {
        head = reverseLinkedList(node)
    }

    fun reverseLinkedList(node: ListNode?): ListNode? {

        if (node == null)
            return node

        if (node.next == null)
            return node

        val newNode = reverseLinkedList(node.next)
        node.next!!.next = node // Create new connection and with next node
        node.next = null //

        return newNode
    }

    fun findCycle(node: ListNode?): Boolean {
        var fast: ListNode? = node
        var slow: ListNode? = node

        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next
            if (slow == fast)
                return true
        }
        return false
    }

    fun findCycleLength(node: ListNode?): Int {

        var fast = node
        var slow = node

        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next

            if (slow == fast) {
                // calculate the length
                var length = 0
                var temp = slow

                do {
                    temp = temp?.next
                    length++
                } while (temp != fast)

                return length
            }

        }
        return 0
    }


    fun detectCycleNode(node: ListNode?): ListNode? {

        var fast = node
        var slow = node
        var length = 0
        //Detect if LinkedList Has cycle
        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next

            if (slow == fast) {
                // calculate the length
                length = findCycleLength(slow)
                break
            }
        }

        // If length is zero then there is no cycle and return null
        if (length == 0) {
            return null
        }

        //Take two pointer first and second
        //Traverse second pointer unitl length reaches to zero
        var first = node
        var second = node

        while (length > 0) {
            if (second != null) {
                second = second.next
            }
            length--
        }

        // Keep moving both pointer until the both meets are 8
        while (first != second) {
            first = first!!.next
            second = second!!.next
        }

        return second
    }

    //    https://leetcode.com/problems/happy-number/
    fun isHappyNumber(num: Int): Boolean {
        var fast = num
        var slow = num

        do {
            slow = findSquare(slow)
            fast = findSquare(findSquare(fast))
        } while (slow != fast)

        if (slow == 1) {
            return true
        }
        return false
    }

    fun findSquare(num: Int): Int {
        var ans = 0
        var n = num
        while (n > 0) {
            val rem = n % 10
            ans += rem * rem
            n /= 10
        }

        return ans
    }

    fun sortList() {
        head = sortList(head)
    }

    private fun sortList(head: ListNode?): ListNode? {
        if (head == null || head.next == null) return head
        val mid = getMid(head)
        val left = sortList(head)
        val right = sortList(mid)
        return merge(left, right)
    }

    fun merge(left: ListNode?, right: ListNode?): ListNode? {
        var l = left
        var r = right
        val dummyHead = ListNode(-1)
        var tail: ListNode? = dummyHead
        while (l != null && r != null) {
            if (l.`val` < r.`val`) {
                tail!!.next = l
                l = l.next
                tail = tail.next
            } else {
                tail!!.next = r
                r = r.next
                tail = tail.next
            }
        }
        tail!!.next = l ?: r
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

    fun isPalindrome(head: ListNode?): Boolean {
        var firstHead = head
        val mid = middleNode(head)
        var reversedHead = reverseLinkedList(mid)
        val rereversedList = reversedHead

        while (firstHead != null && reversedHead != null) {
            if (firstHead.`val` != reversedHead.`val`)
                break

            firstHead = firstHead.next
            reversedHead = reversedHead.next

        }
        reverseLinkedList(rereversedList)

        return head == null || reversedHead == null

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


