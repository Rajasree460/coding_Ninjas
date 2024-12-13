import java.util.*;

public class Solution {
    public static int minCostBST(int[] arr, int[] freq) {
        int n = arr.length;
        long[] pre = new long[n];
        pre[0] = freq[0];
        for (int i = 1; i < n; i++) {
            pre[i] = freq[i] + pre[i - 1];
        }
        
        long[][] dp = new long[n][n];
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) {
                    dp[i][i] = freq[i];
                } else if (g == 1) {
                    long f1 = 2 * freq[i] + freq[j];
                    long f2 = freq[i] + 2 * freq[j];
                    dp[i][j] = Math.min(f1, f2);
                } else {
                    long rem = pre[j];
                    if (i != 0) {
                        rem -= pre[i - 1];
                    }
                    long mini = Long.MAX_VALUE;
                    for (int k = i; k <= j; k++) {
                        long left = 0;
                        if (k != i) {
                            left = dp[i][k - 1];
                        }
                        long right = 0;
                        if (k != j) {
                            right = dp[k + 1][j];
                        }
                        if (rem + left + right < mini) {
                            mini = rem + left + right;
                        }
                    }
                    dp[i][j] = mini;
                }
            }
        }
        return (int) dp[0][n - 1];
    }
}
