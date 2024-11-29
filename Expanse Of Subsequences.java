import java.util.*;

public class Solution {

    public static int expanseOfSubsequences(int[] arr) {
        // Define modulo constant
        final int MOD = 1000000007;

        // Length of the array
        int n = arr.length;

        // Sort the array
        Arrays.sort(arr);

        // Precompute powers of 2 modulo MOD
        long[] powerOfTwo = new long[n];
        powerOfTwo[0] = 1;
        for (int i = 1; i < n; i++) {
            powerOfTwo[i] = (powerOfTwo[i - 1] * 2) % MOD;
        }

        // Initialize result
        long result = 0;

        // Calculate contributions to the expanse
        for (int i = 0; i < n; i++) {
            // Contribution as maximum element
            long maxContribution = (arr[i] * powerOfTwo[i]) % MOD;

            // Contribution as minimum element
            long minContribution = (arr[i] * powerOfTwo[n - i - 1]) % MOD;

            // Add the difference to the result
            result = (result + maxContribution - minContribution + MOD) % MOD;
        }

        return (int) result;
    }
}
