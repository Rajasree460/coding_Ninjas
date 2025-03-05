/*

      at each step, try to divide arr into two sets such that        their size is as close as possible

*/

 

#include <bits/stdc++.h> 

 

int rec(vector<string> &arr)

{

    int n = arr.size();

    if (n==1) return 1;

    if (n==2) return 2;

    if (n==3) return 5;

 

    vector<string> cur1, cur2;

 

    int sz = arr[0].size(), dif=1e5, fid;

    for (int i=0; i<sz; i++)

    {

        int g1=0, g2=0;

        for (int j=0; j<n; j++)

        {

            if (arr[j][i]=='0') g1++;

            else g2++;

        }

        if (dif >= abs(g1-g2))

        {

            dif = abs(g1-g2);

            fid = i;

        }

    }

 

    for (int i=0; i<n; i++)

    {

        if (arr[i][fid]=='0') cur1.push_back(arr[i]);

        else cur2.push_back(arr[i]);

    }

    return n + rec(cur1) + rec(cur2);

}

 

int minimumTouchesRequired(int N, vector<string> arr)

{

    int ans = rec(arr);

    return ans;

}
