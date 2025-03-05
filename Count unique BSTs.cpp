const int MOD = 1000000007;

 

long long totalTrees(int num){

    vector<long long> dp(num + 1, 0);

    dp[0] = 1; 

    dp[1] = 1; 

    

    for (int i = 2; i <= num; ++i) {

        for (int j = 1; j <= i; ++j) {

            dp[i] = (dp[i] + dp[j-1] * dp[i-j]) % MOD;

        }

    }

    

    return dp[num];

}

 
