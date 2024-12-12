// Function to calculate minimum cost.
#include<bits/stdc++.h>>
long long minimumCost(vector<int> &cost, int n, int k)
{
    sort(cost.begin(),cost.end());
    int left=0;
    int right=n-1;
    long long ans=0;
    int count=0;
    while(left<=right){
        ans+=cost[left];
        count=0;
        while(count<k && left<right){
            right--;
            count++;
        }
        left++;
    }
    return ans;
}

// Function to calculate maximum cost.
long long maximumCost(vector<int> &cost, int n, int k)
{
    sort(cost.begin(),cost.end());
    int left=0;
    int right=n-1;
    long long ans=0;
    int count=0;
    while(left<=right){
        ans+=cost[right];
        count=0;
        while(count<k && left<right){
            left++;
            count++;
        }
        right--;
    }
    return ans;
}
