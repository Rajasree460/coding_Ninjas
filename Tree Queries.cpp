#include <iostream>
#include <vector>
using namespace std;

void dfs(int node, int v, vector<int>& vis, vector<vector<int>>& adj, vector<int>& path, bool& found) {
    vis[node] = 1;
    
    if(node == v) {
        found = true;
        return;
    }

    for(auto &it : adj[node]) {
        if(!vis[it] && !found) {  
            path.push_back(it);
            dfs(it, v, vis, adj, path, found);
            if(found) return;  
            path.pop_back();  
        }
    }
}

vector<int> treeQuery(int n, int q, vector<vector<int>>& edges, vector<int>& height, vector<vector<int>>& queries) {
    vector<vector<int>> adj(n + 1);
    for(auto &it : edges) {
        adj[it[0]].push_back(it[1]);
        adj[it[1]].push_back(it[0]);
    }

    vector<int> ans;

    for(auto &it : queries) {
        int type = it[0];
        int u = it[1];
        int v = it[2];

        vector<int> path;
        vector<int> vis(n + 1, 0);
        bool found = false;  
        path.push_back(u);

        dfs(u, v, vis, adj, path, found);

        if(type == 1) {  // Reverse Operation
            int l = 0, r = path.size() - 1;
            while(l < r) {  
                swap(height[path[l]-1], height[path[r]-1]);
                l++;
                r--;
            }

        }

        if(type == 2) {  // Sum Operation
            int sum = 0;
            for(auto &node : path) {
                sum += height[node-1];
            }
            ans.push_back(sum);

        }
    }

    return ans;
}
