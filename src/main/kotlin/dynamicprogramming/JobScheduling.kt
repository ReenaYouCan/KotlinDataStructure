package dynamicprogramming

fun main(args: Array<String>) {
    val jobScheduling = JobScheduling()
    println(jobScheduling.jobScheduling(intArrayOf(6,15,7,11,1,3,16,2), intArrayOf(19,18,19,16,10,8,19,8), intArrayOf(2,9,1,19,5,7,3,19)))
}
class JobScheduling {
    fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
        val n = startTime.size
        val jobs = mutableListOf<Job>()

        for(i in 0 until n)
        {
            val job = Job(startTime[i],endTime[i],profit[i])
            jobs.add(job)
        }

        // sort as per the start time
       val jobsList = jobs.sortedBy{it.startTime}

        return helper(jobsList,n,0)
    }

    fun helper(jobs:List<Job>,n:Int,i:Int) : Int
    {
        if(i>=n)
        {
            return 0
        }

        //next index to find the profit which will be greater than equal to endTime of current job
        val nextIndex = getNextIndex(jobs,i+1,jobs[i].endTime) // Need to write binary search

        // Lets start the actual proces of taking and not taking the element
        val taken = jobs[i].profit + helper(jobs,n,nextIndex)
        val notTaken = helper(jobs,n,i+1)

        return Math.max(taken,notTaken)
    }

    fun getNextIndex(jobs:List<Job>,left:Int,endTime:Int) :Int
    {

        var r = jobs.size - 1
        var l = left
        var result = jobs.size

        while(l<=r)
        {
            val mid = l + (r - l) /2
            if(jobs[mid].startTime>=endTime)
            {
                result = mid
                r = mid-1
            } else
            {
                l = mid+1
            }
        }

        return result

    }

    data class Job(val startTime:Int,val endTime:Int,val profit:Int)
}