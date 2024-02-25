package array

class CreateMatrix {

    fun findMatrix(nums: IntArray): List<List<Int>> {

        val result = mutableListOf<MutableList<Int>>()
        result.add(mutableListOf())

        for (num in nums) {

            for (entry in result) {
                if (!entry.contains(num)) {
                    entry.add(num)
                } else {
                    result.add(mutableListOf(num))
                }
            }
        }
        return result
    }


}