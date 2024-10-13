package queue

import java.util.*

class NumberOfRecentCalls {
    val window = LinkedList<Int>()

    fun ping(t: Int) : Int {
        window.add(t)

        while (window.first < t-3000)
            window.removeFirst()

        return window.size
    }
}

