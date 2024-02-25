package linkedlist

class LinkedListOperations {

}

fun main(args: Array<String>) {

    val linkedListHelper = LinkedListHelper()
    linkedListHelper.addNodeToFront(5)
    linkedListHelper.addNodeToFront(9)
    linkedListHelper.addNodeToFront(1)
    linkedListHelper.addNodeToFront(7)
    linkedListHelper.addNodeToFront(3)

//    linkedListHelper.addNodeToTheTail(10)
//    linkedListHelper.insertAtIndex(11,0)
//    linkedListHelper.insertAtIndex(18,4)

//    linkedListHelper.rInsert(linkedListHelper.head,1,25)


//    linkedListHelper.display(linkedListHelper.head)

//    linkedListHelper.recursiveReverseList(linkedListHelper.head)

//    println("Reversed List")

//    linkedListHelper.display(linkedListHelper.head)

//    linkedListHelper.isHappyNumber(12)

    linkedListHelper.sortList()

    linkedListHelper.displayNode()

}