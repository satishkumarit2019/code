package practice;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static String findShortestSubsegment(String text, List<String> words) {
        // Split text into words, ignoring non-alphabetic characters and making it case-insensitive.
        String[] textWords = text.toLowerCase().split("[^a-zA-Z]+");

        // Store the required frequency of each word.
        Map<String, Integer> requiredCount = words.stream()
                .collect(Collectors.toMap(String::toLowerCase, word -> 1, Integer::sum));

        int requiredWords = requiredCount.size();
        Map<String, Integer> currentWindow = new HashMap<>();

        int minLength = Integer.MAX_VALUE;
        int minStart = -1;

        int left = 0, matchedWords = 0;

        // Sliding window approach.
        for (int right = 0; right < textWords.length; right++) {
            String rightWord = textWords[right];

            if (requiredCount.containsKey(rightWord)) {
                currentWindow.put(rightWord, currentWindow.getOrDefault(rightWord, 0) + 1);

                if (currentWindow.get(rightWord).equals(requiredCount.get(rightWord))) {
                    matchedWords++;
                }
            }

            // Try to shrink the window to find the minimum length sub-segment.
            while (matchedWords == requiredWords) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }

                String leftWord = textWords[left];
                left++;

                if (requiredCount.containsKey(leftWord)) {
                    if (currentWindow.get(leftWord).equals(requiredCount.get(leftWord))) {
                        matchedWords--;
                    }
                    currentWindow.put(leftWord, currentWindow.get(leftWord) - 1);
                }
            }
        }

        if (minStart == -1) {
            return "NO SUBSEGMENT FOUND";
        }

        // Reconstruct the original segment using correct spacing.
       // String[] originalWords = text.split("\\s+");
        text = text.replace(".","");
        String[] originalWords = text.split("\\s+");
        return String.join(" ", Arrays.copyOfRange(originalWords, minStart, minStart + minLength));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the entire text from the first input line.
        String text = scanner.nextLine();

        // Read the number of words (k) to be searched.
        int k = Integer.parseInt(scanner.nextLine());

        // Read the list of k words.
        List<String> words = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            words.add(scanner.nextLine());
        }

        // Find and print the shortest sub-segment.
        String result = findShortestSubsegment(text, words);
        System.out.println(result);

        scanner.close();
    }
}
