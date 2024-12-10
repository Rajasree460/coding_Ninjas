public class Solution
{
public static int maximumProfit(int[] prices, int n, int k)
    {
        int[][] dp = new int[2][k+1];
        for (int i = n - 1; i >= 0; i--) {
            for (int cap = k-1; cap >= 0; cap--) {
                int res = 0;
                dp[0][cap] = Math.max(dp[1][cap] - prices[i], dp[0][cap]);
                dp[1][cap] = Math.max(prices[i] + dp[0][cap + 1], dp[1][cap]);
            }
        }
        return dp[0][0];
    }
}
