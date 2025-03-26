#include<bits/stdc++.h>
int covidSpread(vector<vector<int>> &houses)
{
    //    Write your code here.
    int t=0;// no of non infected persons
    queue<pair<int,int>> q;
    for(int i=0;i<houses.size();i++){
        for(int j=0;j<houses[0].size();j++){
            if(houses[i][j]==2){
                q.push({i,j});
            }
            if(houses[i][j]==1){
                t++;
            }
        }
    }
    int count=0;// days
    int d=0;// no of infected persons
    while(!q.empty()){
        int n=q.size();
        count++;
        while(n--){
            pair<int,int> p=q.front();
            q.pop();
            int dirx[]={-1,0,1,0};
            int diry[]={0,1,0,-1};
            for(int k=0;k<4;k++){
                int nx=p.first+dirx[k];
                int ny=p.second+diry[k];
                if(nx>=0 && nx<houses.size()&& ny>=0 && ny<houses[0].size()&& houses[nx][ny]==1){
                    d++;
                    houses[nx][ny]=2;
                    q.push({nx, ny});
                }
            }
        }
        
    }
    if(d==t) return count-1;
    return -1;
}
