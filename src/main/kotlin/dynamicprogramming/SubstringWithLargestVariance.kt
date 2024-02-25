package dynamicprogramming

class SubstringWithLargestVariance {
    fun largestVariance(s: String): Int {
        val counter = IntArray(26)
        for (ch in s.toCharArray()) {
            counter[(ch.code - 'a'.code)]++
        }
        var globalMax = 0
        for (i in 0..25) {
            for (j in 0..25) {
                // major and minor cannot be the same, and both must appear in s.
                if (i == j || counter[i] == 0 || counter[j] == 0) {
                    continue
                }

                // Find the maximum variance of major - minor.
                val major = ('a' + i)
                val minor = ('a' + j)
                var majorCount = 0
                var minorCount = 0

                // The remaining minor in the rest of s.
                var restMinor = counter[j]
                for (ch in s.toCharArray()) {
                    if (ch == major) {
                        majorCount++
                    }
                    if (ch == minor) {
                        minorCount++
                        restMinor--
                    }

                    // Only update the variance if there is at least one minor.
                    if (minorCount > 0) globalMax = Math.max(globalMax, majorCount - minorCount)

                    // We can discard the previous string if there is at least one remaining minor.
                    if (majorCount < minorCount && restMinor > 0) {
                        majorCount = 0
                        minorCount = 0
                    }
                }
            }
        }
        return globalMax
    }
}
