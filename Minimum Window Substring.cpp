#include <bits/stdc++.h>

using namespace std;

string minSubstring(string &s, string &t){

 

int N = s.size();

int M = t.size();

int sIndex = -1;

int mini = INT_MAX;

vector<int> mp(256, 0);

 

for (int i = 0; i < M; i++)

  mp[t[i]]++;

 

int l = 0, r = 0, count = 0;

while (r < N) {

  if (mp[s[r]] > 0)

    count++;

  mp[s[r]]--;

  while (count == M) {

    if (r - l + 1 < mini) {

      mini = r - l + 1;

      sIndex = l;

    }

    mp[s[l]]++;

    if (mp[s[l]] > 0)

      count--;

    l++;

  }

  r += 1;

}

 

  return sIndex == -1 ? "" : s.substr(sIndex, mini);

}
