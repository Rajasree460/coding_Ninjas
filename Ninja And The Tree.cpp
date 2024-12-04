#include<bits/stdc++.h>

void inorder(TreeNode<int>* root,TreeNode<int>* & prev,TreeNode<int>*&first,TreeNode<int>*&mid,TreeNode<int>*&last)
{
    if (!root) return;
    inorder(root->left,prev,first,mid,last);
    if(prev!=NULL && prev->data> root->data)
    {
        if (first)
        {
           last=root;
        }
        else{
            first=prev;
            mid=root;
        }
    }
    prev=root;
    inorder(root->right,prev,first,mid,last);
}

void recoverTree(TreeNode<int>* root) {
   TreeNode<int>* prev=NULL;
    TreeNode<int>* first=NULL;
     TreeNode<int>* mid=NULL;
      TreeNode<int>* last=NULL;
      inorder(root,prev,first,mid,last);
   if (first && last) swap(first->data , last->data);
   else if (first && mid) swap(first->data,mid->data);
    
}
