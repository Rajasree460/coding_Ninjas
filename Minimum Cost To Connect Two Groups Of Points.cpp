#include <bits/stdc++.h> 

int dp[11][4096];

int F(vector<vector<int>> &cost,int g1Point = 0,int g2PointStart = 0,int mask = 0){

    int g1 = cost.size() , g2 = cost[0].size();

    if(g1Point == g1) return 1+mask == (1<<g2) ? 0 : 1e9;

    if(dp[g1Point][mask] != -1) return dp[g1Point][mask];

    int minCost = 1e9;

    for(int g2Point=g2PointStart;g2Point<g2;g2Point++){

        int currCost = cost[g1Point][g2Point] + min(F(cost,g1Point+1,0,mask|(1<<g2Point)),F(cost,g1Point,g2Point+1,mask|(1<<g2Point)));

        minCost = min(minCost,currCost);

    }

    return dp[g1Point][mask] = minCost;

}

int connectTwoGroups(vector<vector<int>> &cost){

    memset(dp,-1,sizeof dp);

    return F(cost);

}
