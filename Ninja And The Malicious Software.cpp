#include <bits/stdc++.h>
vector<int> p, sz;
int size;
struct dsu{
    void init(int n){
        size=n;
        p.resize(n+1); sz.resize(n+1);
        for(int i=0; i<n; ++i){
            p[i]=i;
            sz[i]=0;
        }
    }
    int find(int x){
        return x^p[x] ? p[x]=find(p[x]) : x;
    }
    void join(int x, int y){
        if( (x=find(x)) == (y=find(y)))
            return;
        if(sz[x]<sz[y]){
            p[x]=y;
            sz[y]+=sz[x];
        }else{
            p[y]=x;
            sz[x]+=sz[y];
        }
    }
};

int minimizeMalwareSpread(int n, vector<vector<int>> &g, int m, vector<int> &infected)
{
    dsu ds; ds.init(n);
    for(int i=0; i<n; ++i)
        for(int j=i+1; j<n; ++j){
            if(g[i][j])
                ds.join(i, j);
        }
    
    vector<int> malwareCount(n);
    //for(int i=0; i<n; ++i)
        //++dsSize[ds.find(i)];
        
    for(auto i: infected)
        ++malwareCount[ds.find(i)];
    
    sort(begin(infected), end(infected));

    int ans=infected[0], mxDSsize=0;

    for(auto i: infected){
        int id = ds.find(i);
        if(sz[id] > mxDSsize && malwareCount[id]==1){
            mxDSsize = sz[id];
            ans = i;
        }
    }
    return ans;
}
