package graph.topologicalsort

import java.util.*


class SortItemByGroupsRespectingDependencies {
    fun sortItems(n: Int, m: Int, group: IntArray, beforeItems: List<List<Int>>): IntArray {
        // If an item belongs to zero group, assign it a unique group id.
        var groupId = m
        for (i in 0 until n) {
            if (group[i] == -1) {
                group[i] = groupId
                groupId++
            }
        }

        // Sort all item regardless of group dependencies.
        val itemGraph: MutableMap<Int, MutableList<Int>> = HashMap()
        val itemIndegree = IntArray(n)
        for (i in 0 until n) {
            itemGraph[i] = ArrayList()
        }

        // Sort all groups regardless of item dependencies.
        val groupGraph: MutableMap<Int, MutableList<Int>> = HashMap()
        val groupIndegree = IntArray(groupId)
        for (i in 0 until groupId) {
            groupGraph[i] = ArrayList()
        }
        for (curr in 0 until n) {
            for (prev in beforeItems[curr]) {
                // Each (prev -> curr) represents an edge in the item graph.
                itemGraph[prev]!!.add(curr)
                itemIndegree[curr]++

                // If they belong to different groups, add an edge in the group graph.
                if (group[curr] != group[prev]) {
                    groupGraph[group[prev]]!!.add(group[curr])
                    groupIndegree[group[curr]]++
                }
            }
        }

        // Topological sort nodes in the graph, return an empty array if a cycle exists.
        val itemOrder = topologicalSort(itemGraph, itemIndegree)
        val groupOrder = topologicalSort(groupGraph, groupIndegree)
        if (itemOrder.isEmpty() || groupOrder.isEmpty()) {
            return IntArray(0)
        }

        // Items are sorted regardless of groups, we need to differentiate them by the groups they belong to.
        val orderedGroups: MutableMap<Int, MutableList<Int>> = HashMap()
        for (item in itemOrder) {
            orderedGroups.computeIfAbsent(
                group[item]
            ) { k: Int? -> ArrayList() }.add(item)
        }

        // Concatenate sorted items in all sorted groups.
        // [group 1, group 2, ... ] -> [(item 1, item 2, ...), (item 1, item 2, ...), ...]
        val answerList: MutableList<Int> = ArrayList()
        for (groupIndex in groupOrder) {
            answerList.addAll(orderedGroups.getOrDefault(groupIndex, ArrayList()))
        }
        return answerList.stream().mapToInt { obj: Int -> obj }.toArray()
    }

    private fun topologicalSort(graph: Map<Int, MutableList<Int>>, indegree: IntArray): List<Int> {
        val visited: MutableList<Int> = ArrayList()
        val stack = Stack<Int>()
        for (key in graph.keys) {
            if (indegree[key] == 0) {
                stack.add(key)
            }
        }
        while (!stack.isEmpty()) {
            val curr = stack.pop()
            visited.add(curr)
            for (prev in graph[curr]!!) {
                indegree[prev]--
                if (indegree[prev] == 0) {
                    stack.add(prev)
                }
            }
        }
        return if (visited.size == graph.size) visited else ArrayList()
    }

}