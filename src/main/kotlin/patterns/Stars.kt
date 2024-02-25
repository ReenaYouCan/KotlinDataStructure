package patterns

fun main(args: Array<String>) {
    val stars = Stars()

    stars.printStars(8)
}

class Stars {
    // Need to check what can be optimize more
    // run
    // Need to bring it to center and need to add space initially
    fun printStars(n: Int) {

        // Print Top Pyramid
        for (i in 0..n step 2) {
            for (p in 0..n - i) {
                print(" ")
            }
            for (j in 0..i) {
                print("* ")
            }
            println()
        }
        // Print Bottom Inverted Pyramid
        for (i in n-2 downTo 0 step 2) {
            for (p in 0..n - i) {
                print(" ")
            }
            for (j in 0..i) {
                print("* ")
            }
            println()
        }
    }


}