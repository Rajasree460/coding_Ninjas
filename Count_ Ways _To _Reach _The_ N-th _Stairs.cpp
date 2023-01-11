 //space optimization
#include <bits/stdc++.h> 
long long mod=1000000007;         
int countDistinctWays(int nStairs) {
    //  Write your code here.
    if(nStairs<=1) return 1;
    int prev1=1,prev2=1;
    int curr;
    for(int i=2;i<=nStairs;i++){
        curr=(prev1+prev2)%mod;
        prev2=prev1%mod;
        prev1=curr%mod;
    }
    return curr%mod;
}
