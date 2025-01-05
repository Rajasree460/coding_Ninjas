#include <bits/stdc++.h>

class Node {
public:
  Node *child[26];
  vector<pair<int, string>> res;

  Node() {
    for (int i = 0; i < 26; i++) {
      child[i] = NULL;
    }
  }
};

class AutocompleteSystem {
public:
  Node *root;
  int size = 0;
  string pat = "";

  void insert(int k, int n, string str) {
    Node *temp = root;

    for (int i = 0; i < n; i++) {
      if (!temp->child[str[i] - 'a']) {
        temp->child[str[i] - 'a'] = new Node();
      }
      temp = temp->child[str[i] - 'a'];
      temp->res.push_back({k, str});
    }
  }

  void find(string s, int n, vector<string> &ans) {
    Node *temp = root;

    for (int i = 0; i < n; i++) {
      if (!temp->child[s[i] - 'a']) {
        ans.push_back("");
        break;
      }
      temp = temp->child[s[i] - 'a'];

      if (i == n - 1) {
        int size = temp->res.size();

        if (size == 1) {
          ans.push_back(temp->res[0].second);
        } else if (size == 2) {
          ans.push_back(temp->res[0].second);
          ans.push_back(temp->res[1].second);
        } else {
          ans.push_back(temp->res[0].second);
          ans.push_back(temp->res[1].second);
          ans.push_back(temp->res[2].second);
        }
      }
    }
  }

  bool static cmp(pair<int, string> a, pair<int, string> b) {
    if (a.first > b.first) {
      return true;
    } else if (a.first == b.first) {
      return a.second < b.second;
    }

    return false;
  }

  AutocompleteSystem(vector<string> &arr, vector<int> &times) {
    root = new Node();
    size = 0;
    pat = "";

    int n = times.size();

    vector<pair<int, string>> p;

    for (int i = 0; i < n; i++) {
      p.push_back({times[i], arr[i]});
    }

    sort(p.begin(), p.end(), cmp);

    for (int i = 0; i < n; i++) {
      insert(p[i].first, p[i].second.length(), p[i].second);
    }
  }

  vector<string> input(char c) {
    vector<string> ans;
    if (c == '#') {
      ans.push_back("");
      return ans;
    }

    pat += c;
    size++;
    find(pat, size, ans);
    return ans;
  }
};
