import java.util.* ;

import java.io.*; 

public class Solution {

    static int findMax(int i,int j1,int j2,int[][] grid,Integer[][][] dp,int r,int c)

    {

        if(j1<0 || j1>=c || j2<0 || j2>=c)

        {

            return (int)-1e8;

        }

        if(dp[i][j1][j2]!=null)

        {

            return dp[i][j1][j2];

        }

        if(i==r-1)

        {

            if(j1==j2)

            {

                return grid[i][j1];

            }else{

                return grid[i][j1]+grid[i][j2];

            }

        }

        int maxi=0;

        for(int dj1=-1;dj1<=+1;dj1++)

        {

            for(int dj2=-1;dj2<=+1;dj2++)

            {

                int val=0;

                if(j1==j2)

                {

                    val+=grid[i][j1];

                }else{

                    val+=grid[i][j1]+grid[i][j2];

                }

                val+=findMax(i+1, j1+dj1, j2+dj2, grid, dp, r, c);

                maxi=Math.max(maxi,val);

            }

        }

        return dp[i][j1][j2]=maxi;

    }

    public static int maximumChocolates(int r, int c, int[][] grid) {

        Integer[][][] dp=new Integer[r][c][c];

        return findMax(0,0,c-1,grid,dp,r,c);

    }

}
