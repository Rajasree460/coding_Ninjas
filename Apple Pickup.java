import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

class PickUpApples {
    int n;
    ArrayList<ArrayList<Integer>> matrix;
    int[][][][] dp;

    public PickUpApples(ArrayList<ArrayList<Integer>> matrix) {
        this.matrix = matrix;
        this.n = matrix.size();
        dp = new int[n+1][n+1][n+1][n+1];
        for(int i = 0;i<=n;i++) {
            for(int j = 0;j<=n;j++) {
                for(int k = 0;k<=n;k++) {
                    for(int l = 0;l<=n;l++)
                        dp[i][j][k][l] = -2;
                }
            }
        }
    }

    public int findApples(int r1, int c1, int r2, int c2) {
        if(r1 == n-1 && c1 == n-1 && r2 == n-1 && c2 == n-1) {
            return matrix.get(r1).get(c1);
        } else if(r1 >= n || c1 >= n || c2 >= n || r2 >= n) {
            return -1;
        } else if(matrix.get(r1).get(c1) == -1 || matrix.get(r2).get(c2) == -1)
            return -1;

        if(dp[r1][c1][r2][c2] != -2) {
            return dp[r1][c1][r2][c2];
        }

        int[][] directions = {{1, 0}, {0, 1}};

        int ans = -1;
        for(int i = 0;i<2;i++) {
            for(int j = 0;j<2;j++) {
                int x1 = r1 + directions[i][0], y1 = c1 + directions[i][1];
                int x2 = r2 + directions[j][0], y2 = c2 + directions[j][1];

                int res = findApples(x1, y1, x2, y2);
                if(res != -1)
                    ans = Math.max(ans, res);
            }
        }

        if(ans >= 0)
        {
            if(r1 == r2 && c1 == c2) {
                ans += matrix.get(r1).get(c1);
            } else {
                ans += matrix.get(r1).get(c1) + matrix.get(r2).get(c2);
            }       
        }

        return dp[r1][c1][r2][c2] = ans;
    }
}

public class Solution {
    public static int collectApples(ArrayList<ArrayList<Integer>> matrix) {
        // Write your code here.
        PickUpApples pickUpApples = new PickUpApples(matrix);
        return Math.max(pickUpApples.findApples(0, 0, 0, 0), 0);
    }
}
