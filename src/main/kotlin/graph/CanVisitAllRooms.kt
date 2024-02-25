package graph

import java.util.LinkedList
import java.util.Queue

class CanVisitAllRooms {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visited = BooleanArray(rooms.size) { false }


//        helper(0, rooms, visited)
        val queue: Queue<Int> = LinkedList()
        queue.add(0)
        bfs(rooms, visited, queue)
        for (i in visited) {
            if (!i) return false
        }

        return true
    }

    fun helper(room: Int, rooms: List<List<Int>>, visited: BooleanArray) {

        if (visited[room])
            return

        visited[room] = true

        val keys = rooms[room]

        for (key in keys) {
            helper(key, rooms, visited)
        }

    }

    fun bfs(rooms: List<List<Int>>, visited: BooleanArray, queue: Queue<Int>) {
        while (queue.isNotEmpty()) {
            val curr = queue.poll()
            visited[curr] = true
            val keys = rooms[curr]

            for (key in keys) {
                if (!visited[key])
                    queue.offer(key)
            }
        }
    }
}