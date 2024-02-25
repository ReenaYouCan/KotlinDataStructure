package graph

import java.util.*


//https://leetcode.com/problems/reconstruct-itinerary/?envType=daily-question&envId=2023-09-14

fun main(args: Array<String>) {
    val result = ReconstructItinerary().findItinerary(
        listOf(
            listOf("JFK", "KUL"), listOf("JFK", "NRT"), listOf("NRT", "JFK")
            //, listOf("ATL", "JFK"), listOf("ATL", "SFO")
        )
    )


    result.forEach { println(it) }
}

class ReconstructItinerary {

    fun findItinerary(tickets: List<List<String>>): List<String> {
        val result = LinkedList<String>()
        val graph = mutableMapOf<String, LinkedList<String>>()

        tickets.forEach {
            val fromCity = it[0]
            val toCity = it[1]
            graph.computeIfAbsent(fromCity) { LinkedList<String>() }.add(toCity)
        }
        val n = tickets.size

        graph.forEach { (t, u) -> u.sort() }

        helper("JFK", n, result, graph)
        return result
    }

    fun helper(city: String, n: Int, result: LinkedList<String>, graph: MutableMap<String, LinkedList<String>>) {

        if(graph.containsKey(city))
        {
            val toCities = graph[city]
            while (!toCities?.isEmpty()!!)
            {
                val toCity = toCities.pollFirst()
                helper(toCity,n, result, graph)
            }
        }

        result.offerFirst(city)

    }


    //        if (result.size == n + 1) {
//            return
//        }

//        val toCities = graph[city]
//
//        result.add(city)
//        // What will be the expected result it list is empty
//        while (toCities?.isNotEmpty() == true) {
//            val toCity = toCities.remove()
//                helper(toCity, n, result, graph)
//        }

    //
}