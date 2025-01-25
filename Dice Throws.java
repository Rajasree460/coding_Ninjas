public class Solution {

    

    public static int diceThrows(int d, int f, int s) {

        // Write you code here

        int mod=(int)(1e9+7);

        int[][] dp=new int[d+1][s+1];

        dp[0][0]=1;

        for(int dice=1;dice<=d;dice++){

            for(int target=1;target<=s;target++){

                int ans=0;

                for(int i=1;i<=f;i++){

                    if(target-i>=0){

                        ans=(ans+dp[dice-1][target-i])%mod;

                    }

                }

                dp[dice][target]=ans%mod;

            }

        }

        return dp[d][s]%mod;

    }

 

}
