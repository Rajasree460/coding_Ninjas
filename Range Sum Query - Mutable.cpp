#include <bits/stdc++.h>

#include <vector>

using namespace std;

class RangeSumQuery {

    void buildTree(vector<int>& ar, vector<int>& tree, int start, int end, int treeNode){

        if(start==end){

            tree[treeNode] = ar[start];

            return;

        }

        int mid = (start+end)/2;

        buildTree(ar, tree, start, mid, 2*treeNode);

        buildTree(ar, tree, mid+1, end, 2*treeNode+1);

        tree[treeNode] = tree[2*treeNode]+tree[2*treeNode+1];

        return;

    }

    void update(vector<int>& ar, vector<int>& tree, int start, int end, int treeNode, int idx, int val){

        if(start==end){

            ar[start] = val;

            tree[treeNode] = val;

            return;

        }

    int mid = (start+end)/2;

    if(idx>mid){

        update(ar, tree, mid+1, end, 2*treeNode+1, idx, val);

    }

    else{

        update(ar, tree, start, mid, 2*treeNode, idx, val);

    }

    tree[treeNode] = tree[2*treeNode]+tree[2*treeNode+1];

}

int qr( vector<int>& tree, int start, int end, int treeNode, int left, int right){

    if(start>end){

        return 0;

    }

    if(start>right || left>end){

        return 0;

    }

    if(start>=left  && end<=right){

        return tree[treeNode];

    }

    int ans1, ans2, ans;

    int mid = (start+end)/2;

    ans1 = qr(tree, start, mid, 2*treeNode, left, right);

    ans2 = qr(tree, mid+1, end, 2*treeNode+1, left, right);

    ans = ans1+ans2;

    return ans;

}

public:

vector<int> ar;

vector<int> tree;

int n;

RangeSumQuery(vector<int> &arr){

    n = arr.size();

    for(int i=0; i<4*n; i++){

        tree.push_back(0);

    }

    for(int i=0; i<n; i++){

        ar.push_back(0);

    }

    for(int i=0; i<n; i++){

        ar[i] = arr[i];

    }

    buildTree(ar, tree, 0, n-1, 1);

}

   void update(int ind, int val){

       update(ar, tree, 0, n-1, 1, ind, val );

    }

 

   int sumOfRange(int l, int r){

       return qr(tree, 0, n-1, 1, l, r);

    }

};  
