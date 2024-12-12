#include <bits/stdc++.h> 
/************************************************************

    Following is the TreeNode class structure

    template <typename T>
    class TreeNode {
       public:
        T data;
        TreeNode<T> *left;
        TreeNode<T> *right;

        TreeNode(T data) {
            this->data = data;
            left = NULL;
            right = NULL;
        }
    };

************************************************************/
void f(TreeNode<int> *root,int sum,int tar,unordered_map<int,int> &mpp,int &cnt){
        if(root==nullptr) return;
        sum+=root->data;

        int rem = sum - tar;
        if(mpp.find(rem)!=mpp.end()) cnt+= mpp[rem];

        mpp[sum]++;
        f(root->left,sum,tar,mpp,cnt);
        f(root->right,sum,tar,mpp,cnt);
        mpp[sum]--;
}

int noWays(TreeNode < int > * root, int k) {
    // Write your code here.
    int cnt=0;
    unordered_map<int,int> mpp;
    mpp[0]=1;

    f(root,0,k,mpp,cnt);
    return cnt;
}
