#include <bits/stdc++.h> 
string manacherAlgo(string s)
{
    // Write your code here.
    int n = s.size();
    int len = 2*n+1;
    vector<char>res(len, '#');
    int i = 1, p = 0;
    while(i<(len))
    {
        res[i] =  s[p++];
        i += 2;
    }
    vector<int>lps(len, 0);
    int maxlen = 0, maxcenter = 0, right = 0, center = 0;
    for(int i = 0;i<len;i++)
    {
        int mirror = 2*center - i;
        if(right > i)
        {
            lps[i] = min(lps[mirror], right - i); //to stay in bounds
        }
        int b = i+lps[i]+1, a = i - lps[i] - 1;
        while(a >=0 and b<len and res[a] == res[b])
        {
            a--;
            b++;
            lps[i]++;
        }
        if(lps[i] > maxlen)
        {
            maxlen = lps[i];
            maxcenter = i;
        }
        if(i+lps[i] > right)
        {
            center = i;
            right = i+lps[i];
        }
    }
    maxlen = max_element(lps.begin(), lps.end()) - (lps.begin());
    return s.substr((maxlen - lps[maxlen])/2, lps[maxlen]);
}
