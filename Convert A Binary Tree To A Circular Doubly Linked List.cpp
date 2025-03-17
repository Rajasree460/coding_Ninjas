#include <bits/stdc++.h> 
/*************************************************************
 
    Following is the Binary Tree node structure

    class BinaryTreeNode {
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

BinaryTreeNode<int>*create(vector<int>&ans){

 

BinaryTreeNode<int>*head=new BinaryTreeNode<int>(ans[0]);

BinaryTreeNode<int>*first=head;

BinaryTreeNode<int>*last=head;

first->left=first->right=NULL;

for(int i=1;i<ans.size();i++){

    BinaryTreeNode<int>*t=new BinaryTreeNode<int>(ans[i]);

    last->right=t;

    t->left=last;

    t->right=NULL;

    last=last->right;

}

last->right=first;

first->left=last;

 

return head;

 

}

 

void Inorder(BinaryTreeNode<int>*root,vector<int>&ans){

    if(!root)return;

 

    Inorder(root->left,ans);

    ans.push_back(root->data);

    Inorder(root->right,ans);

}

BinaryTreeNode<int>* convertInCircularDLL(BinaryTreeNode<int>* root) {

    vector<int>ans;

  Inorder(root,ans);

    

     return create(ans);

 

}
