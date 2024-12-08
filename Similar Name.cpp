#include <bits/stdc++.h>

class Node {
public:
  Node *child[26];
  bool isEnd;

  Node() {
    for (int i = 0; i < 26; i++) {
      child[i] = NULL;
    }
    isEnd = false;
  }
};

class Trie {
public:
  Node *root;

  Trie() { root = new Node(); }

  bool insert(string str) {
    Node *curr = root;
    for (int i = 0; i < str.length(); i++) {
      if (!curr->child[str[i] - 'a']) {
        curr->child[str[i] - 'a'] = new Node();
        if (curr->isEnd) {
          return true;
        }
      }
      curr = curr->child[str[i] - 'a'];
    }

    if (curr->isEnd) {
      return true;
    }
    curr->isEnd = true;

    int count = 0;
    for (int i = 0; i < 26; i++) {
      if (curr->child[i]) {
        count++;
      }
    }

    return count > 0;
  }
};

string findSimilar(vector<string> &A) {
  Trie t;
  for (auto i : A) {
    bool ans = t.insert(i);
    if (ans) {
      return i;
    }
  }

  return "not found";
}
