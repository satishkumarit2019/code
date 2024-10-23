package practice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarraySum {
    public static int longestSubarrayWithSum(int[] arr, int target) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int currentSum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            // Case 1: Check if the entire array from start sums to the target
            if (currentSum == target) {
                maxLength = i + 1;
            }

            // Case 2: Check if (currentSum - target) exists in the map
            if (prefixSumMap.containsKey(currentSum - target)) {
                maxLength = Math.max(maxLength, i - prefixSumMap.get(currentSum - target));
            }

            // Store the first occurrence of the current prefix sum
            prefixSumMap.putIfAbsent(currentSum, i);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 5, -2, 3};
        int target = 3;

        int result = longestSubarrayWithSum(arr, target);
        System.out.println("Length of the longest subarray: " + result);
    }
}
