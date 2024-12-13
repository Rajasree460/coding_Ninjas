import java.util.* ;
import java.io.*; 
public class Solution {
    private static int dp[][];
    public static int minTime(int[][] time, int[][] checkpoints) {
        // Write your code here. 
        int n = time.length; 
        dp = new int[n+1][2];
        for(int temp[]:dp){
            Arrays.fill(temp, -1);
        } 
        return Math.min(getMinTime(0, n, time, checkpoints,0) ,  getMinTime(0, n, time, checkpoints,1));     
    }
    public static int getMinTime(int i ,int n,int[][] time, int[][] checkpoints,int lane){
        if(i >= n)return 0;
        if(dp[i][lane] != -1) return dp[i][lane];
        int min = time[i][lane] + getMinTime(i+1, n, time, checkpoints, lane);
        if(i-1 < checkpoints.length &&  i -1 >= 0 )
            min = Math.min(min , checkpoints[i-1][lane] + getMinTime(i+1, n, time, checkpoints, (lane +1 )%2));
        
        return dp[i][lane] = min;
    }
}
