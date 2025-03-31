#include <bits/stdc++.h>

using namespace std;

 

int minNumOfSemesters(int n, vector<vector<int>> &dependencies, int k) {

    vector<int> graph[n];

    vector<int> inDegree(n, 0);

 

    for (auto &dep : dependencies) {

        int u = dep[0] - 1, v = dep[1] - 1;

        graph[u].push_back(v);

        inDegree[v]++;

    }

 

    vector<int> dp(1 << n, INT_MAX);

    dp[0] = 0;

 

    for (int mask = 0; mask < (1 << n); ++mask) {

        if (dp[mask] == INT_MAX) continue;  

 

        vector<int> available;

        for (int i = 0; i < n; ++i) {

            if (!(mask & (1 << i))) {

                bool canTake = true;

                for (int pre : graph[i]) {

                    if (!(mask & (1 << pre))) {

                        canTake = false;

                        break;

                    }

                }

                if (canTake) {

                    available.push_back(i);

                }

            }

        }

 

        int numAvailable = available.size();

        if (numAvailable == 0) continue;

 

        for (int subMask = 0; subMask < (1 << numAvailable); ++subMask) {

            if (__builtin_popcount(subMask) > k) continue;

 

            int nextMask = mask;

            for (int j = 0; j < numAvailable; ++j) {

                if (subMask & (1 << j)) {

                    nextMask |= (1 << available[j]);

                }

            }

 

            dp[nextMask] = min(dp[nextMask], dp[mask] + 1);

        }

    }

 

    return dp[(1 << n) - 1];

}
