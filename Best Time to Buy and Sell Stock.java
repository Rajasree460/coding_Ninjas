import java.util.Arrays;

public class Solution {

    private static int dp[][][];
    public static int maxProfit(int[] prices) {
        // Write your code here.
        dp = new int[prices.length+1][2][2];
        for(int[][] temp: dp){
            for(int[] t :temp) Arrays.fill(t, -1);
        }
        int val = getMax(0, prices, 0, 1);
        return val;
    }
    public static int getMax(int idx,int[] prices,int tansaction,int flag){
        if(idx == prices.length) return 0;
        if(tansaction >= 2) return 0;
        if(dp[idx][tansaction][flag] != -1) return dp[idx][tansaction][flag];
        if(flag == 1){
            return dp[idx][tansaction][flag] = Math.max(getMax(idx+1, prices, tansaction, flag),
                -prices[idx] + getMax(idx+1, prices, tansaction, 1-flag));
        }else{
            return dp[idx][tansaction][flag] =  Math.max(getMax(idx+1, prices, tansaction,  flag),
                prices[idx] + getMax(idx+1, prices, tansaction+1, 1-flag));
        }
    }
}
