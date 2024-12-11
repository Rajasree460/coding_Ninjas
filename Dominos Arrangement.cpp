#include <bits/stdc++.h> 
#define ll long long
int dominosRearrangement(int n)
{
    // Write your code here.
    ll mod=1e9+7;
    vector<int> fullyFilled(n+1,0),partiallyFilled(n+1,0);
    fullyFilled[2]=3;
    partiallyFilled[1]=1;
    for(int i=3;i<=n;i++){
        fullyFilled[i]=(fullyFilled[i-2]+2*(partiallyFilled[i-1])%mod)%mod;
        partiallyFilled[i]=(fullyFilled[i-1]+partiallyFilled[i-2])%mod;
    }
    return fullyFilled[n]%mod;
}
