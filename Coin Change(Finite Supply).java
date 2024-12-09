public class Solution {
    
    private static final int mod = 1000000007;
	public static int coinChange(int n, int[] coins, int[] freq, int v) {
        int dp [] = new int[v+1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            int coin =  coins[i];
            int count =  freq[i];

            for (int j = v; j >= 0; j--) {
                for (int k = 1; k <= count; k++) {
                    if(j >=  k * coin){
                        dp[j] = (dp[j] + dp[j - k * coin]) % mod; 
                    }
                    else {
                        break;
                    }
                }
            }
        }
        return dp[v];
    }
}
