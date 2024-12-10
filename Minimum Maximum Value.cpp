#include <bits/stdc++.h>
int dp1[102][102];
int dp2[102][102];
int help1(int i,int j,string &s)
{
   if(i==j)
       return s[i]-48;
   if(i>j)
       return 0;
   if(dp1[i][j]!=-1)
       return dp1[i][j];
   else
   {
       int cost=1e8;
       for(int k=i+1;k<=j-1;k=k+2)
       {
           char ch=s[k];
           int x=help1(i,k-1,s);
           int y=help1(k+1,j,s);
           if(ch=='*')
           {
               int temp=x*y;
               cost=min(cost,temp);
           }
           else
           {
               int temp=x+y;
               cost=min(cost,temp);
           }
       }
       return dp1[i][j]=cost;
   }
}
int help2(int i,int j,string &s)
{
   if(i==j)
       return s[i]-48;
   if(i>j)
       return 0;
   if(dp2[i][j]!=-1)
       return dp2[i][j];
   else
   {
       int cost=-1e8;
       for(int k=i+1;k<=j-1;k=k+2)
       {
           char ch=s[k];
           int x=help2(i,k-1,s);
           int y=help2(k+1,j,s);
           if(ch=='*')
           {
               int temp=x*y;
               cost=max(cost,temp);
           }
           else
           {
               int temp=x+y;
               cost=max(cost,temp);
           }
       }
       return dp2[i][j]=cost;
   }
}
vector<int> minMaxValue(string exp){
   // Write your code here.
   memset(dp1,-1,sizeof(dp1));
   memset(dp2,-1,sizeof(dp2));
   int n=exp.size();
   int mini=help1(0,n-1,exp);
   int maxi=help2(0,n-1,exp);
   return {mini,maxi};
}
