import java.util.*;

 

public class Solution {

 

    public static int shoppingSpree(int n, int k) {

        int mod = (int)(1e9 + 7);

        int[][] dp = new int[n + 1][k + 1];

 

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= k; j++) {

                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1] + 1) % mod;

            }

        }

 

        return dp[n][k];

    }

}

 
