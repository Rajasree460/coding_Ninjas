#include <bits/stdc++.h>
using namespace std;

int findToll(int n, int m, vector<vector<int>>& time, vector<vector<int>>& toll) {
    const int INF = 1e9;

    // Create a dp table to store the minimum toll for each node and time
    vector<vector<int>> dp(n, vector<int>(m + 1, INF));

    // Initialize the starting node with toll 0 at time 0
    dp[0][0] = 0;

    // Perform dynamic programming to find the minimum toll for each node and time
    for (int t = 0; t <= m; t++) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (time[j][i] <= t) {
                    dp[i][t] = min(dp[i][t], dp[j][t - time[j][i]] + toll[j][i]);
                }
            }
        }
    }

    // Find the minimum toll to reach the destination node
    int minToll = INF;
    for (int t = 0; t <= m; t++) {
        minToll = min(minToll, dp[n - 1][t]);
    }

    return minToll == INF ? -1 : minToll;
}
