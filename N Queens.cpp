vector<int> r;

bool isPossible(int ro, int ce, int n){
    for(int i=0;i<ro;i++){
        if(r[i] == ce || abs(r[i]-ce) == abs(i-ro)) return false;
    }
    return true;
}

void f(int ro, int n, vector<vector<int>> &ans)
{
    if(n==ro){
        vector<int> res(n*n,0);
        for(int i=0;i<n;i++){
            int ind = i * n + r[i];
            //2d -> 1d
            //(r,c) -> i
              //=>  i = r*n+c;
            res[ind] = 1;
        }
        ans.push_back(res);
        return;
    }

    for(int ce=0;ce<n;ce++){
        if(isPossible(ro,ce,n)){
            r[ro]=ce;
            f(ro+1,n,ans);
            r[ro] = -1;
        }
    }
} 

vector<vector<int>> solveNQueens(int n) {
    // Write your code here.
    r =  vector<int>(n,-1);

    vector<vector<int>> ans;

    f(0,n,ans);
    return ans; 
}   
