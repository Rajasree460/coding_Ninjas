#include <iostream>

#include <string>

#include <vector>

using namespace std;

 

bool isPalindrome(int k, string str) {

    int n = str.size();

    

    if (n == 1) {

        return true;

    }

    

    vector<vector<int>> dp(n, vector<int>(n, 0));

    

    for (int len = 2; len <= n; ++len) {

        for (int i = 0; i <= n - len; ++i) {

            int j = i + len - 1;

            if (str[i] == str[j]) {

                dp[i][j] = dp[i + 1][j - 1];

            } else {

                dp[i][j] = 1 + min(dp[i + 1][j], dp[i][j - 1]);

            }

        }

    }

    

    return dp[0][n - 1] <= k;

}

 
