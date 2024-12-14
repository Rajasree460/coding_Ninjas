#include<bits/stdc++.h>

string Solve(BinaryTreeNode<char> *root , unordered_map<string  ,int> &mp){

   if(!root)        return "#";

   string s="";

   if(!root->left && !root->right){         s=s+to_string(root->data);         return s;    }    s=s+to_string(root->data);

   s=s+Solve(root->left ,mp);

   s=s+Solve(root->right ,mp);

   mp[s]++;

   return s; }

bool similarSubtree(BinaryTreeNode<char> *root){       unordered_map<string  ,int> mp;    Solve(root ,mp);    for(auto x:mp){        if(x.second>=2)            return true;    }    return false; }
