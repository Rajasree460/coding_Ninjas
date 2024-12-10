#include <bits/stdc++.h> 
int findMaxHeight(vector<int> &height, vector<int> &width, vector<int> &length, int n) {
 	// Write your code here
	 vector<vector<int>> cuboids;

        for (int i = 0; i < n; i++) {
            cuboids.push_back({length[i], width[i], height[i]});
            cuboids.push_back({length[i], height[i], width[i]});
            cuboids.push_back({width[i], length[i], height[i]});
            cuboids.push_back({width[i], height[i], length[i]});
            cuboids.push_back({height[i], length[i], width[i]});
            cuboids.push_back({height[i], width[i], length[i]});
        }

        n = cuboids.size();
        vector<int> dp(n, 0);

        sort(cuboids.begin(), cuboids.end(), [&](vector<int> a, vector<int> b) {
            return (a[0] * a[1]) > (b[0] * b[1]);
        });

        for (int i = 0; i < n; i++) {
            dp[i] = cuboids[i][2]; 

            for (int j = 0; j < i; j++) {
                if (cuboids[i][0] < cuboids[j][0] && cuboids[i][1] < cuboids[j][1]) {
                    dp[i] = max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
        }

        return *max_element(dp.begin(), dp.end());
}
