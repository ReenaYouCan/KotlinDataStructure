package hashmap

fun main(args: Array<String>) {
    val groupOfPeople = GroupOfPeople()
    groupOfPeople.groupThePeople(intArrayOf(3,3,3,3,3,1,3))

}
class GroupOfPeople {
    fun groupThePeopleOldWay(groupSizes: IntArray): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        val group = hashMapOf<Int,MutableList<Int>>()
        for(i in groupSizes.indices)
        {
            val groupId = groupSizes[i]
            var list = mutableListOf<Int>()
            if(group.containsKey(groupId))
            {
                list = group[groupId]!!
            }
            list.add(i)
            group[groupId] = list
        }

        group.forEach { (k, v) ->
            if(v.size>k)
            {
                val tempList = mutableListOf<Int>()
                for(person in v)
                {
                    if(tempList.size==k)
                    {
                        val pList = tempList.toMutableList()
                        result.add(pList)
                        tempList.clear()
                    }
                        tempList.add(person)

                }
                if(tempList.isNotEmpty())
                {
                    result.add(tempList)
                }

            } else
            {
                result.add(v)
            }
        }

        return result

    }

    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
        val group = mutableMapOf<Int, MutableList<Int>>()
        val result = mutableListOf<List<Int>>()

        groupSizes.indices.forEach { i ->
            val groupId = groupSizes[i]
            group.computeIfAbsent(groupId) { mutableListOf() }.add(i)

            if (group[groupId]?.size == groupId) {
                result.add(group.remove(groupId)!!)
            }
        }

        result.addAll(group.values)

        return result
    }

}