#include <bits/stdc++.h> 
int determinantOfMatrix(vector<vector<int>> matrix)
{
    int det=0;
    if(matrix.size()==1)return matrix[0][0];
    else if(matrix.size()==2)return matrix[0][0]*matrix[1][1]-matrix[1][0]*matrix[0][1];
    else{
        for(int p=0;p<matrix[0].size();p++){
            vector<vector<int>>temp;
            for(int i=1;i<matrix.size();i++){
                vector<int>row;
                for(int j=0;j<matrix[0].size();j++){
                    if(p!=j)row.push_back(matrix[i][j]);
                }
                if(row.size()>0)temp.push_back(row);
            }
            
            int f = (p%2)?-1:1;
            /*instead of calling power function this will reduce much time */
            
            det=det+matrix[0][p]*pow(-1,p)*determinantOfMatrix(temp);
        }
        return det;
    }

}
int spanningTrees(vector<vector<int>> &adjMatrix, int n, int m)
{
   vector<int>degree(n,0);
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (adjMatrix[i][j] == 1)
            {
                
                degree[i]++;
            }

        }

    }
    for (int i = 0; i < n; i++)
    {
        adjMatrix[i][i] = degree[i];
    }
    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if ((i != j) and adjMatrix[i][j] == 1)
            {
                adjMatrix[i][j] = -1;
            }

        }
    }
    vector<vector<int>>submatrix(n - 1, vector<int>(n - 1));

    for (int i = 1; i < n; i++)
    {
        for (int j = 1; j < n; j++)
        {
            submatrix[i - 1][j - 1] = adjMatrix[i][j];
        }

    }
    return  determinantOfMatrix(submatrix);
   
}
