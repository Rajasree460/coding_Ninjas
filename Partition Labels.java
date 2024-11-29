import java.util.*;

public class Solution {
    public static int[] partitionLabels(String s) {
        // Store the last occurrence of each character
        int[] lastOccurrence = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i;
        }

        // List to store the lengths of each partition
        List<Integer> partitions = new ArrayList<>();
        int start = 0, end = 0;

        // Iterate through the string to find partitions
        for (int i = 0; i < s.length(); i++) {
            // Update the end of the current partition
            end = Math.max(end, lastOccurrence[s.charAt(i) - 'a']);

            // If the current index reaches the end of the partition
            if (i == end) {
                partitions.add(end - start + 1);
                start = i + 1;
            }
        }

        // Convert the list to an array
        int[] result = new int[partitions.size()];
        for (int i = 0; i < partitions.size(); i++) {
            result[i] = partitions.get(i);
        }

        return result;
    }
}
