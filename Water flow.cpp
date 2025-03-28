#include <bits/stdc++.h>

 

void bfs(vector<vector<int>> &a, int n, int m, vector<vector<bool>> &vis, int i, int j, int value){

if(i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || a[i][j] < value){

return;

}

 

vis[i][j] = 1;

 

bfs(a, n, m, vis, i+1, j, a[i][j]);

bfs(a, n, m, vis, i-1, j, a[i][j]);

bfs(a, n, m, vis, i, j+1, a[i][j]);

bfs(a, n, m, vis, i, j-1, a[i][j]);

// vis[i][j] = 0;

}

 

// bool comp(vector<int> a, vector<int> b){

// if(a[0] == b[0]){

// return a[1]<b[1];

// }

// return a[0]<b[0];

// }

 

vector<vector<int>> waterFlow(vector<vector<int>> &a, int n, int m) {

 

vector<vector<int>> ans;

vector<vector<bool>> pacific(n, vector<bool>(m, 0));

vector<vector<bool>> atlantic(n, vector<bool>(m, 0));

for(int i = 0; i < m; i++){

bfs(a, n, m, pacific, 0, i, a[0][i]);

bfs(a, n, m, atlantic, n-1, i, a[n-1][i]);

}

for(int i = 0; i < n; i++){

bfs(a, n, m, pacific, i, 0, a[i][0]);

bfs(a, n, m, atlantic, i, m-1, a[i][m-1]);

}

 

for(int i = 0; i < n; i++){

for(int j = 0; j < m; j++){

if(pacific[i][j] && atlantic[i][j]){

vector<int> t1;

t1.push_back(i);

t1.push_back(j);

ans.push_back(t1);

}

}

}

// sort(ans.begin(), ans.end(), comp);

return ans;

// Write your code here.

}
