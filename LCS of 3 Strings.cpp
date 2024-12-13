#include<bits/stdc++.h>
int LCS(string a, string b, string c) {
	int n=a.size(), m=b.size(), o=c.size(), i, j, k;
	vector<vector<vector<int>>> dp(n+1, vector<vector<int>> (m+1, vector<int> (o+1, 0)));
	for(i=1;i<=n;i++) {
		for(j=1;j<=m;j++) {
			for(k=1;k<=o;k++) {
				if(a[i-1]==b[j-1] && b[j-1]==c[k-1]) dp[i][j][k] = 1+dp[i-1][j-1][k-1];
				else {
					dp[i][j][k]=max({dp[i-1][j][k], dp[i][j-1][k], dp[i][j][k-1]});
				}
			}
		}
	}
	return dp[n][m][o];
}
