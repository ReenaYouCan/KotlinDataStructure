package string

//https://leetcode.com/problems/compare-version-numbers/submissions/1248470504/?envType=daily-question&envId=2024-05-03
fun main() {
    val compareVersions = CompareVersions().compareVersion(version1 = "1.012", version2 = "1.201")
    println(compareVersions)
}

class CompareVersions {
    fun compareVersion(version1: String, version2: String): Int {
        val v1Arr = version1.split(".")
        val v2Arr = version2.split(".")

        var vi = 0
        var vj = 0

        while (vi < v1Arr.size || vj < v2Arr.size) {

            var v1Curr = 0
            var v2Curr = 0

            if (vi < v1Arr.size) {
                v1Curr = v1Arr[vi].toInt()
                vi++
            }

            if (vj < v2Arr.size) {
                v2Curr = v2Arr[vj].toInt()
                vj++
            }

            if (v1Curr < v2Curr)
                return -1
            if (v1Curr > v2Curr)
                return 1
        }
        return 0
    }
}