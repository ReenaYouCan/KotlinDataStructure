package stack

import java.util.*

class AsteroidCollision {
    // This solution does not handle -2,-1 0 1 2 case
    fun asteroidCollision(asteroids: IntArray, size: Int): IntArray {
        val right = Stack<Int>()
        val left = Stack<Int>()

        for (num in asteroids) {
            if (num > 0) {
                right.push(num)
            } else {
                left.push(num)
            }
        }

        while (right.isNotEmpty() && left.isNotEmpty()) {
            val fromRight = right.pop()
            val fromLeft = left.pop()
            // how to compare these two astroids (This is the catch)

            val diff = fromRight + fromLeft
            if (diff > 0) {
                right.push(fromRight)
            }
            if (diff < 0) {
                left.push(fromLeft)
            }

        }

        if (right.isNotEmpty()) {
            // need to covert stack to array
            return right.toIntArray()
        }

        if (left.isNotEmpty()) {
            //need to coveert stack to array
            return left.toIntArray()
        }

        return intArrayOf()
    }

    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = Stack<Int>()

        for (asteroid in asteroids) {
            var shouldPushToTheStack = true

            //Top of stack is +ve
            //current asteroid is -ve

            while (stack.isNotEmpty() && (stack.peek() > 0 && asteroid < 0)) {

                // stack popped Astroid is smaller than current
                if (Math.abs(stack.peek()) < Math.abs(asteroid)) {
                    stack.pop()
                    continue
                }

                //if both are of same size the pop
                if (Math.abs(stack.peek()) == Math.abs(asteroid)) {
                    stack.pop()
                }

                shouldPushToTheStack = false
                break
            }

            if (shouldPushToTheStack) {
                stack.push(asteroid)
            }
        }

        val result = stack.toIntArray()
        result.reverse()

        return result
    }
}