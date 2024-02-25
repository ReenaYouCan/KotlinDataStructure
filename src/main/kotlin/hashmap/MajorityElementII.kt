package hashmap

class MajorityElementII {
    fun majorityElement(nums: IntArray): List<Int> {
        // Take the count of all the numbers
        // Store the count in hashmap-> key = num and value = occurance of that number
        // for each key and value
        // if(value>n/3)
        //{
        //   add key to ans list
        //}
        //return list

        val map = mutableMapOf<Int,Int>()
        val n = nums.size

        for(num in nums)
        {
            map.computeIfAbsent(num){0}
            map[num] = map[num]!!+1
        }

        val result = map.filter { entry ->  entry.value>n/3}

        return ArrayList(result.keys)

    }
}