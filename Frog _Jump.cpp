#include <bits/stdc++.h> 
int frogJump(int n, vector<int> &heights)
{
    // Write your code here.
    int curr, prev1 = 0, prev2 = 0;   //by space optimization
    int fj, sj = INT_MAX;
    for(int i=1; i<n; i++) {
        fj = abs(heights[i] - heights[i-1]) + prev1;
        if(i>1) sj = abs(heights[i] - heights[i-2]) + prev2;
        curr=min(fj,sj);
        prev2=prev1;
        prev1=curr;
    }
    return prev1;
}
