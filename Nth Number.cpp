#include <bits/stdc++.h>

long long dp[20][11][2];

long long F(string &num,int pos=0,int sum=10,int t=1){

   if(pos == num.size() || sum < 0) return sum == 0;

   long long &cnt = dp[pos][sum][t];

   if(cnt != -1) return cnt;

   cnt = 0;

   int limit = t ? num[pos]-'0' : 9;

   for(int d=0;d<=limit;d++) 

      cnt += F(num,pos+1,sum-d,t&(limit==d));

   return cnt;

}

long long nthNumberWithSum10(long long n){

   long long low = 19 , high = 2e18;

   long long ans = -1;

   while(low <= high){

      long long mid = low + (high-low)/2;

      string num = to_string(mid);

      for(int pos=0;pos<num.size();pos++) for(int sum=0;sum<=10;sum++) dp[pos][sum][0] = dp[pos][sum][1] = -1;

      long long cnt = F(num);

      if(cnt < n)  low = mid + 1;

      else ans = mid , high = mid - 1;

   }

   return ans;

}
