#include <bits/stdc++.h>

using namespace std;

 

vector<int> findCost(int n, string s, int m, vector<vector<int>> &queries) {

    vector<string> possibleComb = {"abc", "acb", "bca", "bac", "cba", "cab"};

    vector<vector<int>> dp(6, vector<int>(n + 1, 0));

 

    // Fill the dp table

    for (int i = 0; i < 6; ++i) {

        int count = 0;

        for (int j = 1; j <= n; ++j) {

            if (s[j - 1] != possibleComb[i][j % 3])

                count++;

            dp[i][j] = count;

        }

    }

 

    vector<int> ans;

    // Process queries

    for (int i = 0; i < m; ++i) {

        int l = queries[i][0];

        int r = queries[i][1];

        int minCost = INT_MAX;

 

        for (int j = 0; j < 6; ++j) {

            int cost = dp[j][r] - dp[j][l - 1];

            minCost = min(minCost, cost);

        }

 

        ans.push_back(minCost);

    }

 

    return ans;

}
