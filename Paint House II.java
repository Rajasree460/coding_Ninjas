import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static int helper(int i, int j, int[][] costs, int[][] dp) {
        if (i >= costs.length) return 0;
        if (j != -1 && dp[i][j] != -1) return dp[i][j];

        int res = Integer.MAX_VALUE;
        for (int k = 0; k < costs[i].length; k++) {
            if (k == j) continue;
            res = Math.min(res, costs[i][k] + helper(i + 1, k, costs, dp));
        }
        
        if (j != -1) dp[i][j] = res;
        return res;
    }

    public static int paintCost(int n, int k, int[][] costs) 
	{
   		int[][] dp = new int[n][k];
        for (int[] row : dp) Arrays.fill(row, -1);
        
        return helper(0, -1, costs, dp);
    }  
}
