import java.util.Arrays;

public class Solution {

    static final int INF = Integer.MAX_VALUE;

    public static int tsp(int[][] cost, int start, int mask, int[][] dp) {

        int n = cost.length;

        if (mask == (1 << n) - 1)

            return cost[start][0];

        if (dp[start][mask] != -1)

            return dp[start][mask];

        int ans = INF;

        for (int nextCity = 0; nextCity < n; nextCity++) {

            if ((mask & (1 << nextCity)) == 0) {

                int newMask = mask | (1 << nextCity);

                ans = Math.min(ans, cost[start][nextCity] + tsp(cost, nextCity, newMask, dp));

            }

        }

        return dp[start][mask] = ans;

    }

    public static int shortestRoute(int[][] distance) {

        int n = distance.length;

        int[][] dp = new int[n][1 << n];

        for (int i = 0; i < n; i++)

            Arrays.fill(dp[i], -1);

        return tsp(distance, 0, 1, dp);

    }

}
