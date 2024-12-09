#include <bits/stdc++.h>

using namespace std;

 

static bool compare(const vector<int> &a, const vector<int> &b) {

  return a[0] < b[0] || (a[0] == b[0] && a[1] > b[1]);

}

 

void mySort(vector<vector<int>> &arr) { sort(arr.begin(), arr.end(), compare); }

 

int findMaxEnvelopes(vector<int> &height, vector<int> &width, int n) {

  vector<vector<int>> envelopes;

  for (int i = 0; i < n; i++) {

    envelopes.push_back({width[i], height[i]});

  }

 

  mySort(envelopes);

  int m = envelopes.size();

 

  vector<int> dp;

  dp.push_back(envelopes[0][1]);

 

  for (int i = 1; i < m; i++) {

    if (dp.back() < envelopes[i][1]) {

      dp.push_back(envelopes[i][1]);

    } else {

      int index =

          lower_bound(dp.begin(), dp.end(), envelopes[i][1]) - dp.begin();

      dp[index] = envelopes[i][1];

    }

  }

 

  return dp.size();

}

 
