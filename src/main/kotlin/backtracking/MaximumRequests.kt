package backtracking

internal class Solution {
    var answer = 0
    fun maxRequest(requests: Array<IntArray>, indegree: IntArray, n: Int, index: Int, count: Int) {
        if (index == requests.size) {
            // Check if all buildings have an in-degree of 0.
            for (i in 0 until n) {
                if (indegree[i] != 0) {
                    return
                }
            }
            answer = Math.max(answer, count)
            return
        }

        // Consider this request, increment and decrement for the buildings involved.
        indegree[requests[index][0]]--
        indegree[requests[index][1]]++
        // Move on to the next request and also increment the count of requests.
        maxRequest(requests, indegree, n, index + 1, count + 1)
        // Backtrack to the previous values to move back to the original state before the second recursion.
        indegree[requests[index][0]]++
        indegree[requests[index][1]]--

        // Ignore this request and move on to the next request without incrementing the count.
        maxRequest(requests, indegree, n, index + 1, count)
    }

    fun maximumRequests(n: Int, requests: Array<IntArray>): Int {
        val indegree = IntArray(n)
        maxRequest(requests, indegree, n, 0, 0)
        return answer
    }
}
