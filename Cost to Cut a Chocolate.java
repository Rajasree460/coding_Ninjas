import java.util.* ;

import java.io.*; 

public class Solution {

    public static int Memo(int left,int right,int newcut[],int dp[][]){

        if(right-left<2) return 0;

        if(dp[left][right]!=-1) return dp[left][right];

 

        int mini=(int)1e9;

        for(int idx=left+1;idx<=right-1;idx++){

            int cost=(newcut[right]-newcut[left])+Memo(left,idx, newcut, dp)+Memo(idx, right, newcut, dp);

            mini=Math.min(mini,cost);

        }

        return dp[left][right]= mini;

    }

    public static int cost(int n, int c, int cuts[]) {

 

        // Write your code here..

        int newcut[]=new int[c+2];

        newcut[0]=0;

        for(int i=1;i<c+1;i++){

            newcut[i]=cuts[i-1];

        }

        newcut[c+1]=n;

        Arrays.sort(newcut);

        int dp[][]= new int[c+2][c+2];

        for(int i=0;i<c+2;i++){

            for(int j=0;j<c+2;j++){

                dp[i][j]=-1;

            }

        }

        return Memo(0,c+1, newcut, dp);

    }

 

}
