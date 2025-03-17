#include <bits/stdc++.h> 
/*************************************************************
 
    Following is the Binary Tree node structure

    class BinaryTreeNode 
    {
    public : 
        T data;
        BinaryTreeNode<T> *left;
        BinaryTreeNode<T> *right;

        BinaryTreeNode(T data) {
            this -> data = data;
            left = NULL;
            right = NULL;
        }
    };

*************************************************************/
#include<map>
#include<queue>
vector<int> verticalSumBinaryTree(BinaryTreeNode<int> * root)
{
    map<int,vector<int>> nodes;
    queue<pair<BinaryTreeNode<int>*,pair<int,int>>> q;
    q.push(make_pair(root,make_pair(0,0)));
    vector<int> ans;

    while(!q.empty()){
        pair<BinaryTreeNode<int>*,pair<int,int>> temp = q.front();
        q.pop();
        BinaryTreeNode<int>* node1 = temp.first;
        int hd = temp.second.first;
        int vd = temp.second.second;

        nodes[hd].push_back(node1->data);
        if(node1->left){
            q.push(make_pair(node1->left,make_pair(hd-1,vd+1)));
        }
        if(node1->right){
            q.push(make_pair(node1->right,make_pair(hd+1,vd+1)));
        }
        
    }
    for(auto i: nodes){
            int sum = 0;
            for(auto k: i.second){
                sum+=k;
            }
            ans.push_back(sum);
    }
    return ans;

}
