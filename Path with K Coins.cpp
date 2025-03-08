#include <bits/stdc++.h>
int f(int i, int j, int n, int m, vector<vector<int>>& a, int k,
      vector<vector<vector<int>>>& dp) {
    if (i < 0 || i >= n || j < 0 || j >= m)
        return 0;
    if (i == n - 1 and j == m - 1) {
        return k == a[i][j];
    }
    if (dp[i][j][k] != -1)
        return dp[i][j][k];
    int ans = 0;
    if (k >= a[i][j]) {
        ans += f(i + 1, j, n, m, a, k - a[i][j], dp);
        ans += f(i, j + 1, n, m, a, k - a[i][j], dp);
    }
    return dp[i][j][k] = ans;
}
int pathWithKCoins(vector<vector<int>>& a, int k) {
    int n = a.size(), m = a[0].size();
    vector<vector<vector<int>>> dp(
        n + 1, vector<vector<int>>(m + 1, vector<int>(k + 1, -1)));
    return f(0, 0, n, m, a, k, dp);
}
