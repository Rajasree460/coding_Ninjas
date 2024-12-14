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

BinaryTreeNode<int>* Solve(BinaryTreeNode<int>* root , int targetNodeVal , int &k , bool& found){

 

    if(root ==NULL){

        return NULL;

    }

 

    if(root->data ==targetNodeVal){

        return root;

    }

 

    BinaryTreeNode<int>* leftAns = Solve(root->left , targetNodeVal , k , found);

    BinaryTreeNode<int>* rightAns = Solve(root->right , targetNodeVal , k , found);

 

    if(leftAns!=NULL && rightAns ==NULL){

        k--;

        if(k<=0){

            k = INT_MAX;

            found = true;

            return root;

        }

        return leftAns;

    }

 

    if(leftAns==NULL && rightAns !=NULL){

        k--;

        if(k<=0){

            k = INT_MAX;

            found=true;

            return root;

        }

        return rightAns;

    }

 

    return NULL;

 

}

 

int findKthAncestor(BinaryTreeNode<int> *root, int targetNodeVal, int k ) {

    // Write your code here.

    if(root ==NULL || root->data == targetNodeVal){

        return -1;

    }

 

 

// this bool variable is used to deal with the situation where the kth ancestor of the node does not exist in the tree. 

    bool found =false;

 

    BinaryTreeNode<int>* ans = Solve(root , targetNodeVal , k , found);

 

    if(!found){

        return -1;

    }

 

    return ans->data;

 

}
