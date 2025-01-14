#include <bits/stdc++.h>
int minCostPath(int** cost, int n, int m, int x, int y)
{
    priority_queue<pair<int,pair<int,int>>,vector<pair<int,pair<int,int>>>,
        greater<pair<int,pair<int,int>>>>pq;
    pq.push({cost[0][0],{0,0}});

    vector<vector<int>>dist(n,vector<int>(m,INT_MAX));
    dist[0][0] = 0;
    
    int dr[] = {+1,0,+1};
    int dc[] = {0,+1,+1};

    while(!pq.empty())
    {
        auto itr = pq.top();
        int dis = itr.first;
        int r = itr.second.first;
        int c = itr.second.second;
        pq.pop();

        for(int i = 0; i < 3; i++)
        {
            int nrow = r+dr[i];
            int ncol = c+dc[i];

            if(nrow<n && ncol<m && 
            dis + cost[nrow][ncol] < dist[nrow][ncol])
            {
                dist[nrow][ncol] = dis+cost[nrow][ncol];
                pq.push({dist[nrow][ncol],{nrow,ncol}});
            }
        }
    }
    if(dist[x-1][y-1] == INT_MAX)
        return -1;
    return dist[x-1][y-1];
}
