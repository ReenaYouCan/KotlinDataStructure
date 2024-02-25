package recursion

class Employee {
    var id: Int = 0
    var importance: Int = 0
    var subordinates: List<Int> = listOf()
}

class EmployeeImportance {
    fun getImportance(employees: List<Employee?>, id: Int): Int {

        val empMap = mutableMapOf<Int, Employee>()

        for (emp in employees) {
            empMap[emp!!.id] = emp
        }
        return helper(id, empMap[id]!!.subordinates, empMap)
    }

    fun helper(id: Int, subordinates: List<Int>?, map: MutableMap<Int,Employee>) : Int {
        //Current employee and its subordinates

        if (subordinates.isNullOrEmpty()) {
            return 0
        }

        var importanceSum = map[id]!!.importance
        for (subordinate in subordinates) {
            val currsubordinates = map[subordinate]!!.subordinates
            importanceSum += helper(subordinate, currsubordinates, map)
        }

        return importanceSum

    }
}