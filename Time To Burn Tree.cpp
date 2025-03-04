#include<bits/stdc++.h>
/************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode 
    {
        public : 
        T data;
        BinaryTreeNode<T> *left;
        BinaryTreeNode<T> *right;

        BinaryTreeNode(T data) 
        {
            this -> data = data;
            left = NULL;
            right = NULL;
        }
    };

************************************************************/
// same as print all node at distance k
BinaryTreeNode<int>* parentvisitAndTargetNode(BinaryTreeNode<int>* root,unordered_map<BinaryTreeNode<int>*, BinaryTreeNode<int>*>& parent_track, int start) {
        queue<BinaryTreeNode<int>*> q;
        q.push(root);
        BinaryTreeNode<int> * res;  //finding the target node

        while (!q.empty()) {
            BinaryTreeNode<int>* cp = q.front(); // cp: current parent
            q.pop();
            if(cp->data == start)   res=cp;
            if (cp->left) {
                q.push(cp->left);
                parent_track[cp->left] = cp;
            }
            if (cp->right) {
                q.push(cp->right);
                parent_track[cp->right] = cp;
            }
        }
        return res;
    }
int timeToBurnTree(BinaryTreeNode<int>* root, int start)
{
    // Write your code here
    unordered_map<BinaryTreeNode<int> *, BinaryTreeNode<int> *> parent_track;
    BinaryTreeNode<int>* startN=parentvisitAndTargetNode(root, parent_track,start);

    queue<BinaryTreeNode<int>*> q;
    q.push(startN);

    map<BinaryTreeNode<int>*, bool> visited;
    visited[startN]=true;

    int timer=0;
    int count=0;

    while(!q.empty()){
        int n=q.size();

        int fl=0; // we are using flag becasue their may be possiblity that left right child already visited 
        //timer++; // not using because for above example

        for(int i=0;i<n;i++){
            BinaryTreeNode<int>* node=q.front();
            q.pop();

            if(node->left && !visited[node->left]){
                fl=1; 
                q.push(node->left);
                visited[node->left]=true;
            }
            if(node->right && !visited[node->right]){
                fl=1;
                q.push(node->right);
                visited[node->right]=true;
            }
            if(parent_track[node] && !visited[parent_track[node]]){
                fl=1;
                q.push(parent_track[node]);
                visited[parent_track[node]]=true;
            }
            
        }
        if(fl){
            count++;
        }
    }
    return count;

}
