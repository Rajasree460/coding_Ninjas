#include <bits/stdc++.h>

using namespace std;

 

int informEmployees(vector<int> &manager, vector<int> &timeToInform, int headId) {

unordered_map<int, vector<int>> mp;

 

for (int i = 0; i < manager.size(); i++) {

mp[manager[i]].push_back(i);

}

int ans = 0;

queue<pair<int,int>> q;

q.push({headId,0});

bool havechild = false;

while (!q.empty()) {

int levelSize = q.size();

int count = 0;

for (int i = 0; i < levelSize; i++) {

 

int a = q.front().first;

int b= q.front().second;

q.pop();

ans = max(ans, b);

for (int j = 0; j < mp[a].size(); j++) {

q.push({mp[a][j],b + timeToInform[a]});

 

}

 

 

}

 

}

return ans;

}
