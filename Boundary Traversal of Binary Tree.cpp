// left traversal

void traverseleft (TreeNode<int>*root, vector<int>&ans){

    if(root==NULL || root->left ==NULL && root->right==NULL){

        return;

    }

    ans.push_back(root->data);

    if(root->left){

        traverseleft(root->left,ans);

    }else{

        traverseleft(root->right,ans);

    }

}

// leaf Node trraversal

void traversalEaf(TreeNode<int>*root, vector<int>&ans){

    if(root==NULL){

        return;        

    }

    if(root->left == NULL && root->right==NULL){

        ans.push_back(root->data);

        return;

    }

    traversalEaf(root->left,ans);

    traversalEaf(root->right,ans);

}

 

// right NOde traversal

void  traverseright(TreeNode<int>*root, vector<int>&ans){

    if(root==NULL || root->left ==NULL && root->right==NULL){

        return;

    }

    if(root->right){

        traverseright(root->right,ans);

        }else{

            traverseright(root->left, ans);

        }

        ans.push_back(root->data);

}

 

vector<int> traverseBoundary(TreeNode<int> *root)

{

    // Write your code here.

    vector<int> ans;

    if (root == NULL) {

            return ans;

    }

        ans.push_back(root->data);

        traverseleft(root->left, ans);

        traversalEaf(root->left, ans);

        traversalEaf(root->right, ans);

        traverseright(root->right, ans);

 

}
