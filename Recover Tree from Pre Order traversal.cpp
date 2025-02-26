#include <bits/stdc++.h>

bool isDash(const char &ch) { return ch == '-'; }

pair<string::iterator, TreeNode<int> *> solve(string::iterator beg,
                                              string::iterator end, int l = 0) {
  // base condition
  if (beg >= end)
    return {beg, nullptr};

  // Node Data
  auto nb = find_if_not(beg, end, isDash);
  auto ne = find_if(nb, end, isDash);

  // different level
  if (l != (nb - beg))
    return {beg, nullptr};

  TreeNode<int> *node = new TreeNode<int>(stoi(string(nb, ne)));

  // left subtree
  auto lt = solve(ne, end, l + 1);
  node->left = lt.second;

  // right subtree
  auto rt = solve(lt.first, end, l + 1);
  node->right = rt.second;

  return {rt.first, node};
}

TreeNode<int> *recoverFromPreorder(string S) {
  return solve(S.begin(), S.end()).second;
}
