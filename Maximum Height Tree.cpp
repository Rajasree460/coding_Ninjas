#include <bits/stdc++.h> 

int maxHeight;

int findMaxHeight(int node,vector<int> adjList[],vector<int> &vis){

        vis[node] = 1;

        int maxH1 = 0 , maxH2 = 0;

        for(int adjNode : adjList[node]){

            if(!vis[adjNode]){

                int currH = findMaxHeight(adjNode,adjList,vis);

                if(currH > maxH1){

                    maxH2 = maxH1;

                    maxH1 = currH;

                }

                else if(currH > maxH2) maxH2 = currH;

            }

        }

        maxHeight = max(maxHeight,maxH1+maxH2);

        return 1 + max(maxH1,maxH2);

}

int maximumTreeHeight(int n, vector<vector<int>> &edges){

    vector<int> adjList[n];

    for(vector<int> edge : edges){

        int u = --edge[0];

        int v = --edge[1];

        adjList[u].push_back(v);

        adjList[v].push_back(u);

    }

    maxHeight = 0;

    vector<int> vis(n,0);

    findMaxHeight(0,adjList,vis);

    return maxHeight;

}
