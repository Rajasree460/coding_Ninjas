#include<bits/stdc++.h>

using namespace std;

 

//Problem Link -Omeaga partition

bool PresentSubarray(int index,int target,vector<int>&a,vector<vector<int>>&dp){

    if(index==0)return target==a[index];

    if(dp[index][target]!=-1)return dp[index][target];

    bool notPick=PresentSubarray(index-1, target, a, dp);

    bool pick=false;

    if(target>=a[index])pick=PresentSubarray(index-1, target-a[index], a, dp);

    return dp[index][target]=pick|notPick;

}

int isPartitionPossible(int n, vector<int> a) {

    int sum=0;

    for(int i=0;i<n;i++)sum+=a[i];

    if(sum%2){

        return 0;

    }

    vector<vector<int>>dp(n,vector<int>((sum/2)+1,0));

    int x=sum/2;

    for(int i=0;i<n;i++)dp[i][0]=1;

    dp[0][a[0]]=1;

    for(int i=1;i<n;i++){

        for(int target=1;target<=x;target++){

              bool notPick=dp[i-1][target];

              bool pick=false;

              if(target-a[i]>0)pick=dp[i-1][target-a[i]];

              dp[i][target]=pick|notPick;

        }

    }

    return dp[n-1][x];

}
