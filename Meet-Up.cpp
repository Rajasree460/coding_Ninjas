#include <bits/stdc++.h> 

int delta[5] = {-1,0,+1,0,-1};

struct cell{
    int row , col;
    cell(int r,int c){
        row = r , col = c;
    }
};

int bfs(int sourceRow,int sourceCol,int totalFriends,vector<string> &grid){

    int n = grid.size() , m = grid[0].size();
    vector<vector<int>> vis(n,vector<int>(m,0));

    queue<cell> q;
    q.push(cell(sourceRow,sourceCol));

    int currLevel = 0 , currDist = 0;

    while(!q.empty()){
        int Qsize = q.size();
        for(int i=0;i<Qsize;i++){
            int currRow = q.front().row;
            int currCol = q.front().col;
            q.pop();

            if(grid[currRow][currCol] == 'F'){
                currDist += currLevel;
                if(--totalFriends == 0) return currDist;
                continue;
            } 

            for(int d=0;d<4;d++){
                int newRow = currRow + delta[d];
                int newCol = currCol + delta[d+1];
                if(min(newRow,newCol) >= 0 && newRow < n && newCol < m && grid[newRow][newCol] != '#' && !vis[newRow][newCol]){

                    q.push(cell(newRow,newCol));
                    vis[newRow][newCol] = 1;
                }
            }
        }
        currLevel++;
    }
    return 1e9;
}


int meetUp(vector<string> &grid){
    int n = grid.size() , m = grid[0].size();
    
    int totalFriends = 0 , minDist = 1e9;
    for(string &row : grid) for(char cell : row) totalFriends += cell == 'F';

    if(totalFriends == 0) return 0;

    for(int row=0;row<n;row++){
        for(int col=0;col<m;col++){
            if(grid[row][col] == '.'){
                int currDist = bfs(row,col,totalFriends,grid);
                minDist = min(minDist,currDist);
            }
        }
    }
    return (minDist >= 1e9 ? -1 : minDist);
}
