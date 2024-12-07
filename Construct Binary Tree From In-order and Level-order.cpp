#include <bits/stdc++.h> 


TreeNode* f(vector<int> &inorder,vector<int> &levelorder,int ins,int ine,unordered_map<int,int> &mp){
    if(ins>ine)        
        return NULL;
    
    TreeNode* root=new TreeNode(levelorder[0]); // first element of this levelorder will always be the root
    
    if(levelorder.size()==1){
        return root;
    }//only 1 node which is already inserted therefore return
    
    int inRoot=mp[root->data];  //position of root in inorder array
   
    set<int> leftin;            //using set to store leftsubtree from inorder to reduce search time
    vector<int> leftl,rightl;
    
    for(int i=ins;i<inRoot;i++){
        leftin.insert(inorder[i]);
    }
    
    int n=levelorder.size();
    for(int i=1;i<n;i++){      //already used the first element in root so starting from index=1
        auto itr=leftin.find(levelorder[i]);
        if(itr!=leftin.end()){
             leftl.push_back(*itr);
            leftin.erase(itr);
        }
        else{     //if not in leftsubtree then it is part of the right subtree
            rightl.push_back(levelorder[i]);
        }
    }
   
    root->left=f(inorder,leftl,ins,inRoot-1,mp);
    root->right=f(inorder,rightl,inRoot+1,ine,mp);
    return root;
}
TreeNode* getTreeFromInorderAndLevelorder(int n, vector<int> &inorder, vector<int> &levelorder)
{
	unordered_map<int,int> mp; // using map to reduce search time of root in inorder array
    for(int i=0;i<n;i++){
        mp[inorder[i]]=i;
    }
    return f(inorder,levelorder,0,n-1,mp);
}
