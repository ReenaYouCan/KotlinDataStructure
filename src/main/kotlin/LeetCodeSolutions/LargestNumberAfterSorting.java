package LeetCodeSolutions;

import hashmap.Pair;

import java.util.Arrays;
import java.util.stream.Collectors;
public class LargestNumberAfterSorting {
    public static void main(String[] args) {
        int[] array={9, 5, 34, 3, 30};
        System.out.println(largestNumber(array));
    }
    public static String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";

        // Convert integers to strings and sort based on custom logic
        String result = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .sorted((a, b) -> {
                    // Custom comparator:
                    int sumA = digitSum(a);
                    int sumB = digitSum(b);

                    if (sumA != sumB) {
                        return Integer.compare(sumB, sumA); // Sort by sum of digits (desc)
                    }
                    return (b + a).compareTo(a + b); // Sort by concatenation order
                })
                .collect(Collectors.joining(""));

        // Handle edge case where the largest number is zero
        return result.startsWith("0") ? "0" : result;
    }

    private static int digitSum(String num) {
        return num.chars().map(c -> c - '0').sum();
    }

}


