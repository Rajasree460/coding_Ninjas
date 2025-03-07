#include <bits/stdc++.h>

using namespace std;

 

int minimizeSmoke(vector<int> &color, int n) {

    vector<vector<int>> dp(n, vector<int>(n, 0));

    vector<vector<int>> colorSum(n, vector<int>(n, 0));

 

    for (int i = 0; i < n; ++i) {

        colorSum[i][i] = color[i];

    }

 

    for (int len = 2; len <= n; ++len) { 

        for (int i = 0; i <= n - len; ++i) {

            int j = i + len - 1;

            dp[i][j] = INT_MAX;

            for (int k = i; k < j; ++k) {

                int q = dp[i][k] + dp[k + 1][j] + colorSum[i][k] * colorSum[k + 1][j];

                if (q < dp[i][j]) {

                    dp[i][j] = q;

                    colorSum[i][j] = (colorSum[i][k] + colorSum[k + 1][j]) % 100;

                }

            }

        }

    }

 

    return dp[0][n - 1];

}
