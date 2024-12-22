import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    // Function to find lexicographically larger array between two arrays.
    static boolean isGreater(ArrayList<Integer> firstArr, ArrayList<Integer> secArr, int idx1, int idx2) {
        // Run a loop while both have the same elements or one array ends.
        while (idx1 < firstArr.size() && idx2 < secArr.size() && firstArr.get(idx1).equals(secArr.get(idx2))) {
            idx1++;
            idx2++;
        }
        
        // If the second array ends, then the first array is lexicographically larger or equal.
        if (idx2 == secArr.size()) {
            return true;
        }

        // Check the first different element from 'firstArr' and 'secArr'.
        if (idx1 < firstArr.size() && firstArr.get(idx1) > secArr.get(idx2)) {
            return true;
        }

        return false;
    }

    // Function to merge two arrays to get a lexicographically maximum possible array.
    static ArrayList<Integer> merge(ArrayList<Integer> firstArr, ArrayList<Integer> secArr) {
        ArrayList<Integer> merged = new ArrayList<>();
        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < firstArr.size() || idx2 < secArr.size()) {
            // Check which array is currently lexicographically larger, then add the element of that array into 'merged'.
            if (isGreater(firstArr, secArr, idx1, idx2)) {
                merged.add(firstArr.get(idx1));
                idx1++;
            } else {
                merged.add(secArr.get(idx2));
                idx2++;
            }
        }

        return merged;
    }

    // Function to get lexicographically maximum subsequences of all sizes.
    static void storeDp(ArrayList<Integer> arr, ArrayList<ArrayList<Integer>> dp) {
        int pointer = 0;

        while (!arr.isEmpty()) {
            dp.get(arr.size()).addAll(arr);

            while (pointer < arr.size() - 1 && arr.get(pointer) >= arr.get(pointer + 1)) {
                pointer++;
            }

            arr.remove(pointer);

            if (pointer != 0) {
                pointer--;
            }
        }
    }

    // Function to find the lexicographically maximum possible array.
    public static ArrayList<Integer> maxArray(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<ArrayList<Integer>> dp1 = new ArrayList<>(n + 1);
        ArrayList<ArrayList<Integer>> dp2 = new ArrayList<>(m + 1);

        for (int i = 0; i <= n; i++) {
            dp1.add(new ArrayList<>());
        }

        for (int i = 0; i <= m; i++) {
            dp2.add(new ArrayList<>());
        }

        storeDp(arr1, dp1);
        storeDp(arr2, dp2);
        
        for (int i = 0; i <= Math.min(n, k); i++) {
            if (i <= n && (k - i) <= m) {
                ArrayList<Integer> temp = merge(dp1.get(i), dp2.get(k - i));

                if (isGreater(temp, result, 0, 0)) {
                    result = temp;
                }
            }
        }

        return result;
    }
}
