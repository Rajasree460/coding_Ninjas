import java.util.* ;

import java.io.*; 

import java.util.ArrayList;

public class Solution {

    public static int optimalCost(ArrayList<Integer> keys, ArrayList<Integer> freq, int n) {

        // Write your code here

        int[][] dp = new int[n + 2][n + 2];

        int[] pre = new int[n + 2];

        for (int i = 1; i <= n; i++) {

            pre[i] = pre[i - 1] + freq.get(i - 1);

        }

        pre[n + 1] = pre[n];

        for (int i = 0; i < n; i++) {

            for (int start = 1, end = 1 + i; start <= n - i; start++, end++) {

                int ans = Integer.MAX_VALUE;

                if (i == 0) {

                    dp[start][end] = freq.get(start - 1);

                } else {

                    for (int j = start; j <= end; j++) {

                        ans = Math.min(ans, freq.get(j - 1) + dp[start][j - 1] - pre[start - 1] + pre[j - 1] + dp[j + 1][end] + pre[end] - pre[j]);

                    }

                    dp[start][end] = ans;

                }

            }

        }

        return dp[1][n];

    }

}
