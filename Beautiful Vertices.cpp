#include<bits/stdc++.h>
using namespace std;
int beautifulVertices(int n,int m,vector<vector<int>>&edges){
vector<vector<int>>adj(n+1);
for(auto&e:edges)adj[e[0]].push_back(e[1]),adj[e[1]].push_back(e[0]);
auto countComponents=[&](vector<vector<int>>&graph)->int{
  
vector<int>visited(n+1,0);
int components=0;
function<void(int)>dfs=[&](int u){
visited[u]=1;
for(auto&v:graph[u])if(!visited[v])dfs(v);
};
for(int i=1;i<=n;i++)if(!visited[i])components++,dfs(i);
return components;
};
int initialComponents=countComponents(adj),beautiful=0;
for(int i=1;i<=n;i++){
vector<vector<int>>temp=adj;
for(auto&v:temp[i])temp[v].erase(remove(temp[v].begin(),temp[v].end(),i),temp[v].end());
temp[i].clear();
if(countComponents(temp)>initialComponents)beautiful++;
}
return beautiful;
}
