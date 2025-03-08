#include <bits/stdc++.h> 
/******************************************************************
   
    Structure of TreeNode.
    
    class TreeNode {
        TreeNode < T > ** children;
        int childCount;

        public:
            T data;
            TreeNode(T data);
            int numChildren();
            void addChild(TreeNode < T > * child);
            TreeNode < T > * getChild(int index);
            void setChild(int index, TreeNode < T > * child);
    };

*******************************************************************/

// normal LCA Method 
TreeNode<int>* lca( TreeNode<int>* root, int p, int q ){
    if(!root || root->data == p || root->data == q) return root ; // if NULL or matches returning 
    vector<TreeNode<int>*> v ;
    for( int i = 0 ; i < root->numChildren() ; i++ ){  // iterating over children 
        auto child = root->getChild(i) ;  // geting child 
        if( lca(child,p,q) ){   // if lca not returning NULL 
            v.push_back(lca(child,p,q));   // storing in vector 
        }
    }
    if(v.size() == 2 ) return root ;  // if vec size == 2 then its subtree contains both p and q so LCA is root 
    else if( v.size() == 1) return v[0] ; // if size == 1 returning this only 
    else return NULL ; // else NULL no found 
}

vector<int> find_path( TreeNode<int>* root, int dest ){
    vector<int> path ;
    if(root->data == dest){
        path.push_back(dest) ;
        return path ;
    }
    for(int i = 0 ; i < root->numChildren() ; i++){
        auto child = root->getChild(i) ;
        vector<int> path1 = find_path(child, dest) ;
        if( path1.size() ){
            path1.push_back(root->data) ;
            return path1 ;
        }
    }
    return path ;

}
vector<int> findPath(TreeNode<int>* root, int n1, int n2) {

    TreeNode<int>* lca_ = lca(root,n1,n2) ;  // finding LCA 
    vector<int> path1 = find_path(lca_,n1) ; // Finding reverse Path from LCA to N1   -> Gives ( N1 -> LCA )
    vector<int> path2 = find_path(lca_,n2) ; // Finding reverse Path from LCA to N2   -> Gives ( N2 -> LCA )
    path1.pop_back() ; // Removing LCA from path1  
    reverse(path2.begin(),path2.end()) ;  // revrsing path2 -> Gives ( LCA -> N2 )
    path1.insert( path1.end(), path2.begin(), path2.end() ) ; // concatinating both path 
    return path1 ; // returning path 
}
