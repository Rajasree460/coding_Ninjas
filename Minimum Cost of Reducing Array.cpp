#include <bits/stdc++.h>

int dp[101][101]; 

int f(int i,int j,vector<int> &arr){

    if(i>=j) return 0;

    if(dp[i][j]!=-1) return dp[i][j];

    int ans=1e9;

    int sum=0,s=0;

    for(int k=i;k<=j;k++) sum+=arr[k];

    for(int k=i+1;k<=j;k++){

        ans=min(ans,sum+f(i,k-1,arr)+f(k,j,arr));

    }

    return dp[i][j]=ans;

}

int findMinCost(vector<int> &arr, int n){

    memset(dp,-1,sizeof(dp));

    return f(0,n-1,arr);

}
