import java.util.* ;

import java.io.*; 

public class Solution {

    public static int maximumCoin(int[][] mat, int n, int m) {

        // Write your code here.

        int[][][] dp=new int[n+1][m+1][m+1];

        for(int[][] row1:dp){

            for(int[] row2:row1){

                Arrays.fill(row2,-1);

            }

        }

        return solve(0,0,m-1,n,m,mat,dp);

    }

 

    static int solve(int i,int j1,int j2,int n,int m,int[][] mat,int[][][] dp){

        if(j1<0 || j1>=m || j2<0 || j2>=m || i>=n){

            return (int)(-1e8);

        }

        if(i==n-1 && j1==0 && j2==m-1){

            return dp[i][j1][j2]=(j1!=j2) ? mat[i][j1]+mat[i][j2] :mat[i][j1];

        }

         

        if(dp[i][j1][j2] != -1){

            return dp[i][j1][j2];

        }

        int maxi=Integer.MIN_VALUE;

        for(int dj1=-1;dj1<=1;dj1++){

            for(int dj2=-1;dj2<=1;dj2++){

                int value=0;

                if(j1==j2){

                    value=mat[i][j1];

                }else{

 

                    value=mat[i][j1]+mat[i][j2];

                }

                value+=solve(i+1,j1+dj1,j2+dj2,n,m,mat,dp);

                maxi=Math.max(maxi,value);

            }

        }

        return dp[i][j1][j2]=maxi;

    }

}

 
