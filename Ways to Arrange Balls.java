import java.util.* ;
import java.io.*; 
public class Solution {
    public static long totalWays(int a, int b, int c) {
           long[][][][] dp = new long[a+1][b+1][c+1][4];
           for(int i = 0;i<=a;i++) 
            for(int j = 0; j<=b; j++) 
                for(int k = 0; k<c+1; k++)
                    Arrays.fill(dp[i][j][k], -1);
           return solve(a, b, c, 0, dp);
    }

    public static long solve(int a, int b, int c, int prev, long[][][][] dp) {
        if(a == 0 && b == 0 && c == 0) {
            return 1;
        }
        if(dp[a][b][c][prev] >= 0) {
            return dp[a][b][c][prev];
        }
        long sum = 0;
        for(int i = 1;i<=3;i++) {
            if(prev != i && i == 1 && a > 0) {
                sum += solve(a-1, b, c, i, dp);
            } else if(prev != i && i==2 && b > 0) {
                sum += solve(a, b-1, c, i, dp);
            } else if(prev != i && i == 3 && c > 0) {
                sum += solve(a, b, c-1, i, dp);
            }
        }
        return dp[a][b][c][prev] = sum;
    }
}
