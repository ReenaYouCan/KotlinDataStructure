package math

fun main(args: Array<String>) {
    val excelSheetColumnTitle = ExcelSheetColumnTitle()
//    println(excelSheetColumnTitle.convertToTitle(701))

    println(excelSheetColumnTitle.titleToNumber("ZY"))


}

class ExcelSheetColumnTitle {

    fun convertToTitle(columnNumber: Int): String {
        val result = StringBuilder()

        var columnNum = columnNumber

        while (columnNum > 0) {
            columnNum--
            val rem = columnNum % 26
            result.append('A' + rem)
            columnNum /= 26
        }

        return result.toString().reversed()
    }

    fun titleToNumber(columnTitle: String): Int {

        var place = columnTitle.length

        var result: Int = 0
        while (place > 0) {

            val num = columnTitle[place-1]+1 - 'A'
            var product = 1

            val runLoop = columnTitle.length - place

            for (i in 0 until runLoop) {
                product *= 26
            }
            product *= num

            result += product

            place--
        }

        return result
    }
}