import java.util.*;
public class Solution {

 

    private static int memoization(int ind, int color, int[][]cost, int[][]dp){

        if(ind == 0){

            int mini = Integer.MAX_VALUE;

            for(int i = 0; i < 3; i++){

                if(i != color){

                    mini = Math.min(mini, cost[0][i]);

                }

            }

            return mini;

        }

        if(dp[ind][color] != -1){

            return dp[ind][color];

        }

        int mini = Integer.MAX_VALUE;

        for(int i = 0; i < 3; i++){

            if(i != color){

                int curr = cost[ind][i] + memoization(ind - 1, i, cost, dp);

                mini = Math.min(mini, curr);

            }

            

        }

        return dp[ind][color] = mini;

    }

    public static int minCost(int[][] cost) {

        int[][]dp = new int[cost.length][4];

        for(int[]row : dp){

            Arrays.fill(row, -1);

        }

        return memoization(cost.length - 1, 3, cost, dp);

    }   

}

