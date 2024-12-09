#include <bits/stdc++.h> 

int dfs(int node , map<int ,vector<int>>&adj , vector<vector<int>>&m  , vector<int>&vis , string&colors )
{
  if(adj[node].size()==0)
{
  vis[node]=2; 
  for(int i =0 ; i<26;i++)
  {
    m[node][i]= 0; 
  }
  m[node][colors[node]-'a']+=1; 
  return 1 ;
}
  
vis[node]=1 ;
int ans = 0 ;

for(auto it: adj[node])
{
  
  if(vis[it]==0)
  {
        if(dfs(it, adj , m  ,vis, colors )==1e9)
        return 1e9; 
  for(int i =0 ; i<26;i++)
  {
    m[node][i] = max(m[node][i] , m[it][i]) ;
    ans =max(ans ,m[node][i]) ;
  }     
  }
  else{
    
    if(vis[it]==1)
    return 1e9 ;
     for(int i =0 ; i<26;i++)
  {
    m[node][i] = max(m[node][i] , m[it][i]) ;
    ans =max(ans ,m[node][i]) ;
  } 
  }
}
 m[node][colors[node]-'a']+=1; 
ans =max(ans, m[node][colors[node]-'a'] ) ;
vis[node]=2;


return ans; 
  
}


int maxColourValue(vector<vector<int>> &edges, string &colors){
    // Write your code here.
int n= colors.size() ;
vector<vector<int>>m(n , vector<int>(26,  0)); 
map<int ,vector<int>>adj ;
vector<int>vis(n ,0 );
for(auto it: edges) 
{
  adj[it[0]].push_back(it[1]) ; 
}

int ans = 0; 
for(int i =0 ; i<colors.size(); i++ )
{
  if(vis[i]==0)
  ans= max(ans , dfs(i, adj ,m  ,vis, colors )); 
// cout << vis[1]; 
  if(ans==1e9)
  return -1; 
}
// cout << m[3][colors[4]-'a']<< "x" << endl; 


  return ans ;  
}
