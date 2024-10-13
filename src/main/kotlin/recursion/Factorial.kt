package recursion

fun main() {
    val factorial = Factorial()
    factorial.factorial(5)

}

class Factorial {
    fun factorial(n: Int): Int {
        return if (n <= 1) 1 // Base Case to break the recursion function
        else {
            val fact = n * factorial(n - 1)
            println("Factorial of:$n->$fact")
            fact
        }
    }

    fun reachGround(floor: Int) {
        if (floor == 0) {
            println("You have reached the ground floor.")
            return
        }
        println("Currently on floor $floor. Moving to floor ${floor - 1}.")
        // Recursive call to move down one floor
        reachGround(floor - 1)
    }

    fun reachTopRecursively(currentFloor: Int, targetFloor: Int) {
        if (currentFloor == targetFloor) {
            println("You have reached the $targetFloor floor.")
            return
        }
        println("Currently on floor $currentFloor. Moving to floor ${currentFloor + 1}.")
        // Recursive call to move up one floor
        reachTopRecursively(currentFloor + 1, targetFloor)
    }

}