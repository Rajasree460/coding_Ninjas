#include <bits/stdc++.h> 

/************************************************************

 

    Following is the Tree node structure

    

    template <typename T>

    class TreeNode 

    {

        public : 

        T val;

        TreeNode<T> *left;

        TreeNode<T> *right;

 

        TreeNode(T val) 

        {

            this -> val = val;

            left = NULL;

            right = NULL;

        }

    };

 

************************************************************/

#include <bits/stdc++.h>

 

void inorder(TreeNode<int> *root, int &ans, int &c)

{

    if(root==NULL)

    return ;

    inorder(root->left,ans,c);

    inorder(root->right,ans,c);

    int l=0,r=0;

    if(root->left==NULL && root->right==NULL)

    c++;

    if(root->left!=NULL)

    l=root->left->val;

 

    if(root->right!=NULL)

    r=root->right->val;

    ans=max(ans,root->val+l+r);

    root->val=root->val+max(l,r);

    ans=max(root->val,ans);

 

}

long long int findMaxSumPath(TreeNode<int> *root)

{

   int ans=-1,c=0;

     inorder(root,ans,c);

     if(c==1)

     return -1;

     return ans;

}
