int rec(string&str,vector<vector<int>>&dp,int i,int j)

{

    int mod =1e9+7;

    if(i==j) return 1;

    if(i>j)return 0;

    if(dp[i][j]!=-1)return dp[i][j];

    if(str[i]==str[j])

    {

        dp[i][j]=(1+rec(str,dp,i+1,j)+rec(str,dp,i,j-1))%mod;

    }

    else

    {

        dp[i][j]=((rec(str,dp,i+1,j)+rec(str,dp,i,j-1)-rec(str,dp,i+1,j-1))%mod+mod)%mod;

    }

    return dp[i][j];

}

int countPalindromicSubsequences(string &s)

{

    int n = s.size();

    vector<vector<int>>dp(n,vector<int>(n,-1));

    return rec(s,dp,0,n-1);

}

