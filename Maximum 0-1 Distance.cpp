#include <bits/stdc++.h> 

bool isValid(vector<vector<int>>&matrix,int i,int j) {
	return i>=0 && j>=0 && i<matrix.size() && j<matrix[0].size() && matrix[i][j]==0;
}

int maximumZeroOneDistance(vector<vector<int>>&matrix,int N,int M) {
	int ans=0;
	queue<vector<int>>q;
	for(int i=0;i<N;i++) {
		for(int j=0;j<M;j++) {
			if(matrix[i][j]==1) {
				q.push({i,j,0});
				matrix[i][j]=-1;
			}
		}
	}
	if(q.empty() || q.size()==N*M) {
		return -1;
	}
	int dx[4]={-1,1,0,0};
	int dy[4]={0,0,-1,1};
	while(!q.empty()) {
		auto node=q.front();
		q.pop();
		for(int k=0;k<4;k++) {
			int x=node[0]+dx[k],y=node[1]+dy[k];
			if(isValid(matrix,x,y)) {
				matrix[x][y]=-1;
				ans=max(ans,node[2]+1);
				q.push({x,y,node[2]+1});
			}
		}
	}
	return ans;
}
